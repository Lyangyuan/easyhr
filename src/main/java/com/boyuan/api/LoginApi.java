package com.boyuan.api;

import com.boyuan.base.utils.CookieUtil;
import com.boyuan.domain.User;
import com.boyuan.enums.SessionKeyEnum;
import com.boyuan.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author jiangbo
 * @date 2017\11\18 0018
 */
@Controller
@RequestMapping("/admin")
public class LoginApi {

    @Autowired
    private LoginService loginService;

    public static int cookieKeepTime = 1000 * 60 * 60 * 24 * 7;

    public static int sessionKeepTime = 1000 * 60 * 60 * 3;

    private static final String REMEMBER_VALUE = "on";

    private static final String PAGE_PREFIX = "admin/%s";

    /**
     * 没有权限异常
     * @return
     */
    @RequestMapping("/noPermission")
    public String noPermission(){
        return String.format(PAGE_PREFIX,"noPermission");
    }

    /**
     * 登录页面
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginPage(@RequestParam(name = "errorMsg",required = false) String errorMsg,ModelMap model) throws Exception{
        errorMsg = errorMsg == null ? "":errorMsg;
        model.addAttribute("errorMsg",errorMsg);

        return String.format(PAGE_PREFIX,"login");
    }

    /**
     * 登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,RedirectAttributes attributes) throws Exception{
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        try{
            User user = loginService.login(account,password);
            request.getSession().invalidate();
            request.getSession().setAttribute(SessionKeyEnum.ACCOUNT.getKey(),user.getAccount());
            request.getSession().setAttribute(SessionKeyEnum.TOKEN.getKey(),user.getToken());
            request.getSession().setMaxInactiveInterval(sessionKeepTime);

            if(REMEMBER_VALUE.equals(remember)){
                CookieUtil.addCookie(response,SessionKeyEnum.ACCOUNT.getKey(),user.getAccount(),cookieKeepTime);
                CookieUtil.addCookie(response,SessionKeyEnum.TOKEN.getKey(),user.getToken(),cookieKeepTime);
            }
        }catch (Exception e){
            attributes.addAttribute("errorMsg",e.getMessage());
            return "redirect:login";
        }
        return "redirect:/dashboard/index";
    }

    /**
     * 退出
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, Model model) throws Exception{
        // 清除数据库中的token
        String account = session.getAttribute(SessionKeyEnum.ACCOUNT.getKey()).toString();
        loginService.logout(account);
        // 清除session
        session.removeAttribute(SessionKeyEnum.ACCOUNT.getKey());
        session.removeAttribute(SessionKeyEnum.TOKEN.getKey());
        session.invalidate();

        model.addAttribute("errorMsg","");
        return String.format(PAGE_PREFIX,"login");
    }
}
