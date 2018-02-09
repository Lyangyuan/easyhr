package com.boyuan.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jiangbo
 * @time 2018/1/20
 */
@Controller
@RequestMapping("/permission/user")
public class UserAPi {

    private static final String PAGE_PREFIX = "permission/user/%s";

    @RequestMapping("/index")
    public String index(){

        return String.format(PAGE_PREFIX,"index");
    }
}
