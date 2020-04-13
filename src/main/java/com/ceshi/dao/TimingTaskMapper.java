package com.ceshi.dao;

import com.ceshi.entity.TimingTask;

public interface TimingTaskMapper {
    int insert(TimingTask record);

    int insertSelective(TimingTask record);

    void setScheduledTasks(TimingTask timingTask);
}