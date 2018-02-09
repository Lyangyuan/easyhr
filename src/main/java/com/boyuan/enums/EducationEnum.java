package com.boyuan.enums;

/**
 * @author jiangbo
 * @time 2017/11/25
 */
public enum EducationEnum {

    a("小学"),b("初中"),c("高中"),d("职业技术"),e("中专"),f("大专"),g("本科"),h("硕士"),i("博士");

    private String education;

    EducationEnum(String education) {
        this.education = education;
    }

    public String getEducation() {
        return education;
    }
}
