package com.boyuan.base;

import com.boyuan.domain.RoleUser;
import com.boyuan.domain.User;
import com.boyuan.repository.RoleUserRepository;
import com.boyuan.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/20
 */
public class PermissionInterceptor implements HandlerInterceptor {

    @Autowired
    private AuthenticateService authenticateService;

    @Autowired
    private RoleUserRepository roleUserRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User)request.getAttribute("user");

        HttpSession session = request.getSession();
        List<RoleUser> roleUsers = roleUserRepository.findByUserId(user.getId());
        if(!CollectionUtils.isEmpty(roleUsers)){
            session.setAttribute("role",roleUsers.get(0).getRole().getRoleName());
        }

        String requestURI = request.getRequestURI();
        List<String> urls = authenticateService.getPermissionUrls();
        /* url不需要授权 */
        if(!urls.contains(requestURI)){
            return true;
        }

        // 登陆成功后还需要权限认证
//        if(!authenticateService.checkPermission(user,requestURI)){
//            response.sendRedirect(request.getContextPath() +"/admin/noPermission");
//            return false;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
