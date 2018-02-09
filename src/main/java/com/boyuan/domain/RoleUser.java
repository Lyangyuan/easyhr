package com.boyuan.domain;


import javax.persistence.*;

/**
 * @author jiangbo
 * @time 2018/1/1
 */
@Entity
@Table(name = "easyhr_user_role")
public class RoleUser extends BaseEntity {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", insertable = false, updatable = false, referencedColumnName = "id")
    private User user;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role_id", insertable = false, updatable = false, referencedColumnName = "id")
    private Role role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
