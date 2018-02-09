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

    @Column(name = "module")
    private String module;

    @Column(name = "url")
    private String url;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
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
