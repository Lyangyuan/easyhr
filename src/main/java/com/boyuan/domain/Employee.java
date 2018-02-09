package com.boyuan.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author jiangbo
 * @time 2017/11/25
 */
@Entity
@Table(name = "easyhr_employee")
public class Employee extends BaseEntity {

    @Column(name = "is_locked")
    private Integer isLocked;

    @Column(name = "token")
    private String token;

    @Column(name = "resource_id")
    private Long resourceId;

    @ManyToOne(targetEntity = Resource.class)
    @JoinColumn(name = "resource_id", insertable = false, updatable = false)
    private Resource resource;

    @Column(name = "resume_source")
    private String resumeSource;

    /***
     * 工号
     */
    @Column(name = "number")
    private int number;

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 花名
     */
    @Column(name = "nickname")
    private String nickname;

    /**
     * 岗位
     */
    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name = "post_id", insertable = false, updatable = false,nullable = false)
    private Post post;

    /**
     * 职级
     */
    @Column(name = "grade")
    private String grade;

    /**
     * 电话
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 企业邮箱
     */
    @Column(name = "enterprise_email")
    private String enterpriseEmail;

    /**
     * 个人邮箱
     */
    @Column(name = "personal_email")
    private String personalEmail;

    /**
     * 性别 0-男 1-女
     */
    @Column(name = "sex")
    private int sex;

    /**
     * 身份证号
     */
    @Column(name = "id_card_no")
    private String IdCardNo;

    /**
     * 生日
     */
    @Column(name = "birthday")
    private Timestamp birthday;

    /**
     * 年龄
     */
    @Transient
    private int age;

    /**
     * 入职日期
     */
    @Column(name = "entry_date")
    private Timestamp entryDate;

    /**
     * 工龄
     */
    @Transient
    private int entryAge;

    /**
     * 学历
     */
    @Column(name = "education")
    private String education;

    /**
     * 毕业院校
     */
    @Column(name = "graduate_school")
    private String graduateSchool;

    /**
     * 专业
     */
    @Column(name = "major")
    private String major;

    /**
     * 劳动合同签订日期
     */
    @Column(name = "contract_date")
    private Timestamp contractDate;

    /**
     * 劳动合同期限
     */
    @Column(name = "term")
    private int term;

    /**
     * 到期日期
     */
    @Transient
    private Timestamp expireDate;

    /**
     * 是否到期 0-否 1-是
     */
    @Column(name = "is_expire")
    private int isExpire;

    /**
     * 是否党员 0-否 1-是
     */
    @Column(name = "is_party_member")
    private int isPartyMember;

    /**
     * 民族
     */
    @Column(name = "nation")
    private String nation;

    /**
     * 出生地
     */
    @Column(name = "birth_address")
    private String birthAddress;

    /**
     * 是否已婚 0-否 1-是
     */
    @Column(name = "is_married")
    private int isMarried;

    /**
     * 子女状况
     */
    @Column(name = "children")
    private String children;

    /**
     * 户籍类型
     */
    @Column(name = "residence_type")
    private String residenceType;

    /**
     * 户口所在地址
     */
    @Column(name = "residence_address")
    private String residenceAddress;

    /**
     * 现居住地址
     */
    @Column(name = "current_live_address")
    private String currentLiveAddress;

    /**
     * 社保缴纳地址
     */
    @Column(name = "social_security_address")
    private String socialSecurityAddress;

    /**
     * 紧急联系人1
     */
    @Column(name = "emergency_contact_one_name")
    private String emergencyContactOneName;

    /**
     * 紧急联系人1号码
     */
    @Column(name = "get_emergency_contact_one_phone")
    private String getEmergencyContactOnePhone;

    /**
     * 紧急联系人1与本人关系
     */
    @Column(name = "relationship_one")
    private String relationshipOne;

    /**
     * 紧急联系人2
     */
    @Column(name = "emergency_contact_two_name")
    private String emergencyContactTwoName;

    /**
     * 紧急联系人2号码
     */
    @Column(name = "get_emergency_contact_two_phone")
    private String getEmergencyContactTwoPhone;

    /**
     * 紧急联系人2与本人关系
     */
    @Column(name = "relationship_two")
    private String relationshipTwo;

    /**
     * 内部关系
     */
    @Column(name = "inner_relationship")
    private String innerRelationship;

    /**
     * 备注
     */
    @Column(name = "remarks")
    private String remarks;

    /**
     * 银行卡号
     */
    @Column(name = "bank_card")
    private String bankCard;

    /**
     * 开户行地址
     */
    @Column(name = "bank_card_address")
    private String bankCardAddress;

    @Column(name = "status")
    private int status;

    @Column(name = "candidate_id")
    private Long candidateId;

    public Integer getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Integer isLocked) {
        this.isLocked = isLocked;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getResumeSource() {
        return resumeSource;
    }

    public void setResumeSource(String resumeSource) {
        this.resumeSource = resumeSource;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEnterpriseEmail() {
        return enterpriseEmail;
    }

    public void setEnterpriseEmail(String enterpriseEmail) {
        this.enterpriseEmail = enterpriseEmail;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIdCardNo() {
        return IdCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        IdCardNo = idCardNo;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Timestamp getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Timestamp entryDate) {
        this.entryDate = entryDate;
    }

    public int getEntryAge() {
        return entryAge;
    }

    public void setEntryAge(int entryAge) {
        this.entryAge = entryAge;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Timestamp getContractDate() {
        return contractDate;
    }

    public void setContractDate(Timestamp contractDate) {
        this.contractDate = contractDate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public Timestamp getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Timestamp expireDate) {
        this.expireDate = expireDate;
    }

    public int getIsExpire() {
        return isExpire;
    }

    public void setIsExpire(int isExpire) {
        this.isExpire = isExpire;
    }

    public int getIsPartyMember() {
        return isPartyMember;
    }

    public void setIsPartyMember(int isPartyMember) {
        this.isPartyMember = isPartyMember;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthAddress() {
        return birthAddress;
    }

    public void setBirthAddress(String birthAddress) {
        this.birthAddress = birthAddress;
    }

    public int getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(int isMarried) {
        this.isMarried = isMarried;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getResidenceType() {
        return residenceType;
    }

    public void setResidenceType(String residenceType) {
        this.residenceType = residenceType;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getCurrentLiveAddress() {
        return currentLiveAddress;
    }

    public void setCurrentLiveAddress(String currentLiveAddress) {
        this.currentLiveAddress = currentLiveAddress;
    }

    public String getSocialSecurityAddress() {
        return socialSecurityAddress;
    }

    public void setSocialSecurityAddress(String socialSecurityAddress) {
        this.socialSecurityAddress = socialSecurityAddress;
    }

    public String getEmergencyContactOneName() {
        return emergencyContactOneName;
    }

    public void setEmergencyContactOneName(String emergencyContactOneName) {
        this.emergencyContactOneName = emergencyContactOneName;
    }

    public String getGetEmergencyContactOnePhone() {
        return getEmergencyContactOnePhone;
    }

    public void setGetEmergencyContactOnePhone(String getEmergencyContactOnePhone) {
        this.getEmergencyContactOnePhone = getEmergencyContactOnePhone;
    }

    public String getRelationshipOne() {
        return relationshipOne;
    }

    public void setRelationshipOne(String relationshipOne) {
        this.relationshipOne = relationshipOne;
    }

    public String getEmergencyContactTwoName() {
        return emergencyContactTwoName;
    }

    public void setEmergencyContactTwoName(String emergencyContactTwoName) {
        this.emergencyContactTwoName = emergencyContactTwoName;
    }

    public String getGetEmergencyContactTwoPhone() {
        return getEmergencyContactTwoPhone;
    }

    public void setGetEmergencyContactTwoPhone(String getEmergencyContactTwoPhone) {
        this.getEmergencyContactTwoPhone = getEmergencyContactTwoPhone;
    }

    public String getRelationshipTwo() {
        return relationshipTwo;
    }

    public void setRelationshipTwo(String relationshipTwo) {
        this.relationshipTwo = relationshipTwo;
    }

    public String getInnerRelationship() {
        return innerRelationship;
    }

    public void setInnerRelationship(String innerRelationship) {
        this.innerRelationship = innerRelationship;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getBankCardAddress() {
        return bankCardAddress;
    }

    public void setBankCardAddress(String bankCardAddress) {
        this.bankCardAddress = bankCardAddress;
    }
}
