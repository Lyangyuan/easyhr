package com.boyuan.dto;

/**
 * @author jiangbo
 * @time 2018/2/11
 */
public class BaseDTO {

    private String sortDir = "desc";

    private String sortCol = "gmtModified";

    private int pageIndex = 0;

    private int pageSize = 15;

    public String getSortDir() {
        return sortDir;
    }

    public void setSortDir(String sortDir) {
        this.sortDir = sortDir;
    }

    public String getSortCol() {
        return sortCol;
    }

    public void setSortCol(String sortCol) {
        this.sortCol = sortCol;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
