package com.ceshi.entity;

import java.util.Date;

public class TimingTask {
    /**
    * id
    */
    private Integer id;

    /**
    * 定时任务时间
    */
    private String timingTask;

    /**
    * 创建时间
    */
    private Date creationTime;

    /**
    * 修改时间
    */
    private Date modificationTime;

    /**
    * 是否删除
    */
    private String delete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimingTask() {
        return timingTask;
    }

    public void setTimingTask(String timingTask) {
        this.timingTask = timingTask;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }
}