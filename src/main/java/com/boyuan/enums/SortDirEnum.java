package com.boyuan.enums;

/**
 * @author jiangbo
 * @time 2018/2/7
 */
public enum SortDirEnum {

    DESC("desc"),ASC("asc");

    private String dir;

    SortDirEnum(String dir) {
        this.dir = dir;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
}
