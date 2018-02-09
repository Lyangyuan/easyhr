package com.boyuan.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jiangbo
 * @time 2018/1/5
 */
@Controller
@RequestMapping("/resource")
public class ResourceApi {

    private static final String PAGE_PREFIX = "resource/%s";

    @RequestMapping("/index")
    public String index(){
        // TODO 捞资源
        return String.format(PAGE_PREFIX,"index");
    }
}
