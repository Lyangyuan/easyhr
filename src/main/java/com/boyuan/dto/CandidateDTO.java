package com.boyuan.dto;

/**
 * @author jiangbo
 * @time 2018/1/4
 */
public class CandidateDTO extends BaseDTO{

    private String name;

    private String status;

    private Long postId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
