package com.boyuan.domain;

import javax.persistence.*;

/**
 * @author jiangbo
 * @time 2017/11/25
 */
@Entity
@Table(name = "easyhr_interview_record")
public class InterviewRecord extends BaseEntity {

    /**
     * 面试记录
     */
    @Column(name = "record")
    private String record;

    /**
     * 是否锁定 0-未锁定，1-锁定
     */
    @Column(name = "is_locked")
    private int isLocked;

    /**
     * 候选人Id
     */
    @Column(name = "candidate_id")
    private Long candidateId;

    /**
     * 候选人
     */
    @ManyToOne(targetEntity = Candidate.class)
    @JoinColumn(name = "candidate_id", insertable = false, updatable = false)
    private Candidate candidate;

    /**
     * 步骤
     */
    @Column(name = "step")
    private String step;

    @Column(name = "token")
    private String token;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee employee;

    @Column(name = "employee_id")
    private Long employeeId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public int getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(int isLocked) {
        this.isLocked = isLocked;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
