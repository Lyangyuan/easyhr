package com.boyuan.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author jiangbo
 * @date 2017\11\18 0018
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "gmt_created",nullable = false)
    private Timestamp gmtCreated;

    @Column(name = "gmt_modified",nullable = false)
    private Timestamp gmtModified;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "created_user_id", insertable = false, updatable = false,nullable = false)
    private User createdUser;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "modified_user_id", insertable = false, updatable = false,nullable = false)
    private User modifiedUser;

    @Column(name = "created_user_id")
    private Long createdUserId;

    @Column(name = "modified_user_id")
    private Long modifiedUserId;

    @Column(name = "is_deleted")
    private int isDeleted;

    public Long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Timestamp gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    public User getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(User createdUser) {
        this.createdUser = createdUser;
    }

    public User getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(User modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
