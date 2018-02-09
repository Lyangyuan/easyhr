package com.boyuan.enums;

/**
 * @author jiangbo
 * @time 2017/11/26
 */
public enum RemindModeEnum {

    NULL(0),PHONE(1),EMAIL(2);

    private int mode;

    RemindModeEnum(int mode) {
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }
}
