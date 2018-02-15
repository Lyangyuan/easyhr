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

    @Column(name = "module_one")
    private String moduleOne;

    @Column(name = "module_two")
    private String moduleTwo;

    @Column(name = "url")
    private String url;

    public String getModuleOne() {
        return moduleOne;
    }

    public void setModuleOne(String moduleOne) {
        this.moduleOne = moduleOne;
    }

    public String getModuleTwo() {
        return moduleTwo;
    }

    public void setModuleTwo(String moduleTwo) {
        this.moduleTwo = moduleTwo;
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
