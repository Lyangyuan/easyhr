package com.boyuan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author jiangbo
 * @time 2017/11/25
 */
@Entity
@Table(name = "easyhr_remind")
public class Remind extends BaseEntity {

    /**
     * 提醒类型
     */
    @Column(name = "remind_type")
    private int remindType;

    /**
     * 提醒内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 提醒时间
     */
    @Column(name = "remind_time")
    private Timestamp remindTime;

    /**
     * 提醒方式
     */
    @Column(name = "remind_mode")
    private int remindMode;

    /**
     * 提醒次数
     */
    @Column(name = "remind_times")
    private int remindTimes;

    /**
     * 延期时间
     */
    @Column(name = "delay_time")
    private int delayTime;

    public int getRemindMode() {
        return remindMode;
    }

    public void setRemindMode(int remindMode) {
        this.remindMode = remindMode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(Timestamp remindTime) {
        this.remindTime = remindTime;
    }

    public int getRemindType() {
        return remindType;
    }

    public void setRemindType(int remindType) {
        this.remindType = remindType;
    }

    public int getRemindTimes() {
        return remindTimes;
    }

    public void setRemindTimes(int remindTimes) {
        this.remindTimes = remindTimes;
    }

    public int getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
    }
}
