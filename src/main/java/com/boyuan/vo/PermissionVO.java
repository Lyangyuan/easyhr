package com.boyuan.vo;

import java.util.List;

public class PermissionVO {

    private Long id;

    private String name;

    private int level;

    private boolean checked;

    private List<PermissionVO> children;

    public PermissionVO(Long id, String name, int level, boolean checked) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.checked = checked;
    }

    public List<PermissionVO> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionVO> children) {
        this.children = children;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
