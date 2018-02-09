package com.boyuan.enums;

/**
 * @author jiangbo
 * @time 2018/1/5
 */
public enum ResourceTypeEnum {

    DOC("doc"),PDF("pdf"),EXCEL("excel"),URL("url"),HTML("html");

    private String type;

    ResourceTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
