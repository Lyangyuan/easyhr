package com.boyuan.domain;

import javax.persistence.*;

/**
 * @author jiangbo
 * @time 2018/1/1
 */
@Entity
@Table(name = "easyhr_role_permission")
public class RolePermission extends BaseEntity {

    @Column(name = "role_id")
    private Long roleId;

    @Column(name =" permission_id")
    private Long permissionId;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role_id", insertable = false, updatable = false, referencedColumnName = "id")
    private Role role;

    @ManyToOne(targetEntity = Permission.class)
    @JoinColumn(name = "permission_id", insertable = false, updatable = false, referencedColumnName = "id")
    private Permission permission;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
