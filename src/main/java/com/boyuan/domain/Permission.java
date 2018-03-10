package com.boyuan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jiangbo
 * @time 2018/1/1
 */
@Entity
@Table(name = "easyhr_permission")
public class Permission extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private int level;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "url")
    private String url;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
