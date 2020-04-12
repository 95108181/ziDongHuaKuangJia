package com.ceshi.scheduled;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * 定时任务并行执行
 **/
@Configuration
public class ScheduledConfig implements SchedulingConfigurer {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Override
  public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
    scheduledTaskRegistrar.setScheduler(poolScheduler());
//    //添加定时任务1
//    scheduledTaskRegistrar.addFixedRateTask(new IntervalTask(
//        new Runnable() {
//          @Override
//          public void run() {
//            System.out.println("1111111111111111111111111");
//          }
//        },
//        1000, 0));
//    //添加定时任务2
//    scheduledTaskRegistrar.addFixedRateTask(new IntervalTask(
//        new Runnable() {
//          @Override
//          public void run() {
//            System.out.println("22222222222222222222222");
//          }
//        },
//        2000, 0));
  }

  @Bean(destroyMethod = "shutdown")
  public Executor poolScheduler() {
    return Executors.newScheduledThreadPool(2); // 3个线程来处理。
  }

}
