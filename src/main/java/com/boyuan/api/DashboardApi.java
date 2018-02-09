package com.boyuan.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jiangbo
 * @time 2018/1/20
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardApi {

    @RequestMapping(value = "/index")
    public String index(){

        return "index";
    }

    @RequestMapping(value = "/pannel1")
    public Object pannel1(){

        return null;
    }
}
