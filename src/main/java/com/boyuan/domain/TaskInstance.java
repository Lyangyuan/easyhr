package com.boyuan.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author jiangbo
 * @time 2018/1/6
 */
@Entity
@Table(name = "easyhr_task_instance")
public class TaskInstance extends BaseEntity{

    @ManyToOne(targetEntity = Task.class)
    @JoinColumn(name = "task_id", insertable = false, updatable = false, referencedColumnName = "id")
    private Task task;

    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "execute_user_id")
    private Long executeUserId;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "stop_time")
    private Timestamp stopTime;

    @Column(name = "finished_time")
    private Timestamp finishedTime;

    @Column(name = "progress")
    private int progress;

    @Column(name = "status")
    private int status;

    @Column(name = "summary")
    private String summary;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getExecuteUserId() {
        return executeUserId;
    }

    public void setExecuteUserId(Long executeUserId) {
        this.executeUserId = executeUserId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getStopTime() {
        return stopTime;
    }

    public void setStopTime(Timestamp stopTime) {
        this.stopTime = stopTime;
    }

    public Timestamp getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Timestamp finishedTime) {
        this.finishedTime = finishedTime;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
