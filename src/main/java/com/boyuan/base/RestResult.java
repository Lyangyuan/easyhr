package com.boyuan.base;

/**
 * @author jiangbo
 * @time 2018/1/5
 */
public class RestResult {

    private Integer code;

    private String message;

    private Object date;

    public RestResult(Integer code, String message, Object date) {
        this.code = code;
        this.message = message;
        this.date = date;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
