package com.boyuan.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jiangbo
 * @time 2017/11/25
 */
@Controller
@RequestMapping("/memorandum")
public class MemorandumApi{

    private static final String PAGE_PREFIX = "memorandum/%s";

    @RequestMapping("/index")
    public String index()
    {
        return String.format(PAGE_PREFIX,"index");
    }

    // 其他接口

}
