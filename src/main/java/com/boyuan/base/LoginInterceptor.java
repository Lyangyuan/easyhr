package com.boyuan.base;

import com.boyuan.api.LoginApi;
import com.boyuan.base.utils.CookieUtil;
import com.boyuan.domain.User;
import com.boyuan.enums.SessionKeyEnum;
import com.boyuan.service.AuthenticateService;
import com.boyuan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author jiangbo
 * @date 2017\11\18 0018
 */
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        HttpSession session = request.getSession();
        String account = (String)session.getAttribute(SessionKeyEnum.ACCOUNT.getKey());
        String token = (String)session.getAttribute(SessionKeyEnum.TOKEN.getKey());

        // session过期
        if(account == null || token == null){
            Cookie tokenCookie = CookieUtil.getCookie(request,SessionKeyEnum.TOKEN.getKey());
            Cookie accountCookie = CookieUtil.getCookie(request,SessionKeyEnum.ACCOUNT.getKey());
            if(tokenCookie != null ){
                token = tokenCookie.getValue();
            }
            if(accountCookie != null){
                account = accountCookie.getValue();
            }
            // cookie过期
            if(token == null || account == null){
                response.sendRedirect(request.getContextPath() +"/admin/login");
                return false;
            }

            //将account和token放入session
            session.setAttribute(SessionKeyEnum.ACCOUNT.getKey(),account);
            session.setAttribute(SessionKeyEnum.TOKEN.getKey(),token);
            session.setMaxInactiveInterval(LoginApi.sessionKeepTime);
        }

        // 获取用户信息
        User user = userService.getUser(account);
        // token不正确,重新登陆
        if(user.getToken() == null || !user.getToken().equals(token) || user.getIsFreeze() == 1){
            logger.info(String.format(ErrorMsg.TOKEN_WRONG,account,token));
            response.sendRedirect(request.getContextPath() +"/admin/login");
            return false;
        }

        request.setAttribute("user",user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
