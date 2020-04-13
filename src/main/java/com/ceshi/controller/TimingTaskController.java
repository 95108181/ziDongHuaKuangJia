package com.ceshi.controller;

import com.ceshi.service.TimingTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/timing")
public class TimingTaskController {

    @Autowired
    TimingTaskService timingTaskService;

    /**
     * 设置定时任务
     * @param scheduled
     * @return
     */
    @ResponseBody
    @PostMapping("/setScheduledTasks")
    public BaseResult setScheduledTasks(String scheduled) {
        Boolean status = timingTaskService.setScheduledTasks(scheduled);
        if (status) {return BaseResult.Success();} else {return BaseResult.Error("设置定时任务失败，请重新设置！");}
    }


}
