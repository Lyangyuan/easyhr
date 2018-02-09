package com.boyuan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jiangbo
 * @time 2018/1/5
 */
@Entity
@Table(name = "easyhr_template")
public class Template extends BaseEntity{

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 描述
     */
    @Column(name = "desc")
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
