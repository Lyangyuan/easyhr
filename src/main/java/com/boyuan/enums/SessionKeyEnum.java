package com.boyuan.enums;

/**
 * @author jiangbo
 * @date 2017\11\18 0018
 */
public enum SessionKeyEnum {

    TOKEN("easyhr_token"),ACCOUNT("easy_account");

    private String key;

    SessionKeyEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
