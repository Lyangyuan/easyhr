package com.boyuan.api;

import com.boyuan.domain.User;
import com.boyuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jiangbo
 * @time 2018/1/20
 */
@Controller
@RequestMapping("/account")
public class AccountAPi {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(@RequestAttribute("user")User user,ModelMap map){
        map.addAttribute("userInfo",user);
        return "account/index";
    }

    // 其他接口
}
