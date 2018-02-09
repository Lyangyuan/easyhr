package com.boyuan.domain;

import javax.persistence.*;

/**
 * @author jiangbo
 * @time 2017/11/25
 */
@Entity
@Table(name = "easyhr_candidate")
public class Candidate extends BaseEntity {

    /**
     * 候选人姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 后续是否想录用 0-否 1-是
     */
    @Column(name = "is_employment_later")
    private int isEmploymentLater;

    /**
     * 岗位1
     */
    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    private Post post;

    /**
     * 岗位2
     */
    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name = "post2_id", insertable = false, updatable = false)
    private Post post2;

    @Column(name = "post_id")
    private Long postId;

    @Column(name = "post2_id")
    private Long post2Id;

    /**
     * 简历Id
     */
    @Column(name = "resource_id")
    private Long resourceId;

    @ManyToOne(targetEntity = Resource.class)
    @JoinColumn(name = "resource_id", insertable = false, updatable = false)
    private Resource resource;

    /**
     * 简历来源
     */
    private String resumeSource;

    /**
     * 候选人电话
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 候选人地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 上家单位名称
     */
    @Column(name = "pre_company_name")
    private String preCompanyName;

    /**
     * 上家单位类型
     */
    @Column(name = "pre_company_type")
    private String preCompanyType;

    /**
     * 当前薪资
     */
    @Column(name = "salary")
    private double salary;

    /**
     * 加班费计算方式
     */
    @Column(name = "overtime")
    private String overtime;

    /**
     * 是否缴纳五险 0-否 1-是 2-未知
     */
    @Column(name = "is_pay_five_insurance")
    private int isPayFiveInsurance;

    /**
     * 是否缴纳一金 0-否 1-是 2-未知
     */
    @Column(name = "is_pay_fund")
    private int isPayFund;

    /**
     * 是否包吃 0-否 1-是 2-未知
     */
    @Column(name = "is_provide_food")
    private int isProvideFood;

    /**
     * 是否包住 0-否 1-是 2-未知
     */
    @Column(name = "is_provide_house")
    private int isProvideHouse;

    /**
     * 候选人状态
     */
    @Column(name = "status")
    private String status;

    public String getResumeSource() {
        return resumeSource;
    }

    public void setResumeSource(String resumeSource) {
        this.resumeSource = resumeSource;
    }

    public Post getPost2() {
        return post2;
    }

    public void setPost2(Post post2) {
        this.post2 = post2;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getPost2Id() {
        return post2Id;
    }

    public void setPost2Id(Long post2Id) {
        this.post2Id = post2Id;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsEmploymentLater() {
        return isEmploymentLater;
    }

    public void setIsEmploymentLater(int isEmploymentLater) {
        this.isEmploymentLater = isEmploymentLater;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPreCompanyName() {
        return preCompanyName;
    }

    public void setPreCompanyName(String preCompanyName) {
        this.preCompanyName = preCompanyName;
    }

    public String getPreCompanyType() {
        return preCompanyType;
    }

    public void setPreCompanyType(String preCompanyType) {
        this.preCompanyType = preCompanyType;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }

    public int getIsPayFiveInsurance() {
        return isPayFiveInsurance;
    }

    public void setIsPayFiveInsurance(int isPayFiveInsurance) {
        this.isPayFiveInsurance = isPayFiveInsurance;
    }

    public int getIsPayFund() {
        return isPayFund;
    }

    public void setIsPayFund(int isPayFund) {
        this.isPayFund = isPayFund;
    }

    public int getIsProvideFood() {
        return isProvideFood;
    }

    public void setIsProvideFood(int isProvideFood) {
        this.isProvideFood = isProvideFood;
    }

    public int getIsProvideHouse() {
        return isProvideHouse;
    }

    public void setIsProvideHouse(int isProvideHouse) {
        this.isProvideHouse = isProvideHouse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
