package com.boyuan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jiangbo
 * @time 2017/11/25
 */
@Entity
@Table(name = "easyhr_post")
public class Post extends BaseEntity {

    /**
     * 岗位名称
     */
    @Column(name = "post_name",nullable = false)
    private String postName;

    /**
     * 岗位简介
     */
    @Column(name = "post_introduction")
    private String postIntroduction;

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostIntroduction() {
        return postIntroduction;
    }

    public void setPostIntroduction(String postIntroduction) {
        this.postIntroduction = postIntroduction;
    }
}
