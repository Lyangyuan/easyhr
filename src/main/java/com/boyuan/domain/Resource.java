package com.boyuan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jiangbo
 * @time 2018/1/5
 */
@Entity
@Table(name = "easyhr_resource")
public class Resource extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "origin_name")
    private String originName;

    @Column(name = "type")
    private String type;

    @Column(name = "location")
    private String location;

    @Column(name = "desc")
    private String desc;

    @Column(name = "content")
    private String content;

    @Column(name = "parent_id")
    private Long parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
