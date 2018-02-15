package com.boyuan.vo;

import com.boyuan.domain.Permission;

import java.util.List;

public class PermissionVO {

    private String module;

    private List<Permission> permissions;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
