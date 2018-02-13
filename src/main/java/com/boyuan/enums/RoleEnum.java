package com.boyuan.enums;

public enum  RoleEnum {

    SUPER_ADMIN(1L),ADMIN(2L),GENERAL_USER(3L);

    private Long role;

    RoleEnum(Long role) {
        this.role = role;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }
}
