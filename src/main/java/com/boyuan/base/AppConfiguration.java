package com.boyuan.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author jiangbo
 * @time 2018/1/5
 */
@Component
public class AppConfiguration {

    @Value("${easyhr.upload}")
    private String upload;

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }
}
