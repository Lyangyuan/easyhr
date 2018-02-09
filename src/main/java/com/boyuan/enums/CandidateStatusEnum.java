package com.boyuan.enums;

/**
 * @author jiangbo
 * @time 2017/11/25
 */
public enum CandidateStatusEnum {

    a("意向"),b("到面"),c("一面通过"),d("二面通过"),e("终面通过"),f("发放offer"),g("入职");

    private String status;

    CandidateStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
