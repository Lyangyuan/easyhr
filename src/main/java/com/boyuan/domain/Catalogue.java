package com.boyuan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jiangbo
 * @time 2018/1/5
 */
@Entity
@Table(name = "easyhr_catalogue")
public class Catalogue extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name ="parent_id")
    private Long parentId;

    @Column(name = "level")
    private Integer level;

    @Column(name = "order_value")
    private Integer orderValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Integer orderValue) {
        this.orderValue = orderValue;
    }
}
