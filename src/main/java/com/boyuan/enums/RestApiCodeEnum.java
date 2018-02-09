package com.boyuan.enums;

/**
 * @author jiangbo
 * @time 2018/1/5
 */
public enum RestApiCodeEnum {

    SUCCESS(0),FAIL(1);

    private int code;

    RestApiCodeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
