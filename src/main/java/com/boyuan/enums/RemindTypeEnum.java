package com.boyuan.enums;

/**
 * @author jiangbo
 * @time 2017/11/26
 */
public enum RemindTypeEnum {

    BIRTH(0),INTERVIEW(1),MEMORANDUM(2);

    private int type;

    RemindTypeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
