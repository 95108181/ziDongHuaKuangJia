package com.ceshi;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

//此注解表示动态扫描DAO接口所在包
@MapperScan("com.ceshi.dao")
//此注解表示增加支持定时任务的注解
@EnableScheduling
//此注解表示开启缓存功能
@EnableCaching
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class Application {
  private static final Logger logger = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) throws Exception {
    logger.info("》》》》》》》》》》》》开始启动《《《《《《《《《《《《");
    SpringApplication.run(Application.class, args);
    logger.info("》》》》》》》》》》》》启动成功《《《《《《《《《《《《");
  }
}
