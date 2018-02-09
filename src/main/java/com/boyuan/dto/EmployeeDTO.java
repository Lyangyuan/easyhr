package com.boyuan.dto;

import java.sql.Timestamp;

/**
 * @author jiangbo
 * @time 2018/2/7
 */
public class EmployeeDTO {

    private Integer pageIndex = 0;

    private Integer pageSize = 15;

    private String sortDir = "desc";

    private String sortCol = "entryDate";

    private Long postId;

    private Timestamp entryTimeStart;

    private Timestamp entryTimeEnd;

    private Integer status;

    private Integer number;

    private String name;

    private String nickname;

    private Integer sex;

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

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Timestamp getEntryTimeStart() {
        return entryTimeStart;
    }

    public void setEntryTimeStart(Timestamp entryTimeStart) {
        this.entryTimeStart = entryTimeStart;
    }

    public Timestamp getEntryTimeEnd() {
        return entryTimeEnd;
    }

    public void setEntryTimeEnd(Timestamp entryTimeEnd) {
        this.entryTimeEnd = entryTimeEnd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
