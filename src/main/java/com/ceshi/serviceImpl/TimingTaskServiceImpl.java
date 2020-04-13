package com.ceshi.serviceImpl;

import com.ceshi.Application;
import com.ceshi.dao.TimingTaskMapper;
import com.ceshi.entity.TimingTask;
import com.ceshi.service.TimingTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("TimingTaskService")
class TimingTaskServiceImpl implements TimingTaskService {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    TimingTaskMapper timingTaskMapper;
    @Override
    public Boolean setScheduledTasks(String scheduled) {
        TimingTask timingTask = new TimingTask();
        timingTask.setTimingTask(scheduled);
        if (timingTask.getTimingTask().equals(null)){
            timingTaskMapper.setScheduledTasks(timingTask);
            return true;
        }
        return false;
    }
}
