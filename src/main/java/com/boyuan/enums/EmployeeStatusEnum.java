package com.boyuan.enums;

/**
 * @author jiangbo
 * @time 2018/2/7
 */
public enum EmployeeStatusEnum {

    /**
     * 在职
     */
    WORK(0),

    /**
     * 离职
     */
    LEAVE(1);

    private Integer status;

    EmployeeStatusEnum(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
