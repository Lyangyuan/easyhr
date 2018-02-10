package com.boyuan.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jiangbo
 * @time 2018/1/20
 */
@Controller
public class DashboardApi {

    /**
     * 首页
     */
    @RequestMapping(value = "/")
    public String index(){
        // TODO 仪表盘需要的数据

        return "index";
    }
}
