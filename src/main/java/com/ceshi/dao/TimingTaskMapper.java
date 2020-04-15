package com.ceshi.dao;

import com.ceshi.entity.TimingTask;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface TimingTaskMapper {
    int insert(TimingTask record);

    int insertSelective(TimingTask record);

    void setScheduledTasks(TimingTask timingTask);

    List<TimingTask> findAll();


    void delete(@Param("id")Integer id);
}