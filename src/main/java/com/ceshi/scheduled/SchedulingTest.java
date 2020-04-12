package com.ceshi.scheduled;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ceshi.dao.CcTokenMapper;
import com.ceshi.dao.TestDataDao;
import com.ceshi.entity.CcToken;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import test.TestngRun;

import java.io.IOException;
import java.util.Date;

/**
 * 定时任务窜行执行
 **/
@Component
public class SchedulingTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    TestDataDao testDataDao;

    @Autowired
    CcTokenMapper ccTokenMapper;



    //添加定时任务1
//    @Scheduled(cron = "*/5 * * * * ?") // 每5秒执行一次
//    public void scheduler() throws Exception {
//        TestngRun testngRun = new TestngRun();
//        testngRun.run();
//        logger.info("定时执行测试任务");
//    }


    /**
     * 添加定时任务,获取登录token
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    @Scheduled(cron = "30 10 * * * ?") // 每小时的10分30秒触发任务
    public  String getVerificationCode() throws IOException, InterruptedException {

        //获取验证码
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json,text/plain");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"areaCode\": 86,\r\n    \"phone\" : 17323226097,\r\n    \"verifyType\" : 4\r\n}");
        Request request = new Request.Builder()
                .url("https://api.testing.clipclaps.tv/sms/verify")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Type", "text/plain")
                .build();
        Response response = client.newCall(request).execute();
        // 获取头部
        Headers rsultHeaders = response.headers();
        // 获取身体信息
        String rsultBody = response.body().string();
        JSONObject joRsultBody = JSONObject.parseObject(rsultBody);
        System.out.println(joRsultBody.getJSONObject("data").get("verifyCode"));
        String verifyCode= JSON.toJSONString(joRsultBody.getJSONObject("data").get("verifyCode"));
        Assert.assertNotNull(verifyCode);

        //等待2秒
        Thread.sleep(2000);

        //获取ccToken
        OkHttpClient loginClient = new OkHttpClient().newBuilder().build();
        MediaType loginMediaType = MediaType.parse("application/json,text/plain");
        RequestBody loginBody = RequestBody.create(loginMediaType, "{\r\n\t\"areaCode\":86,\r\n\t\"phone\":17323226097,\r\n\t\"verifyCode\":"+verifyCode+"\r\n}");
        Request loginRequest = new Request.Builder()
                .url("https://api.testing.clipclaps.tv/account/login")
                .method("POST", loginBody)
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Type", "text/plain")
                .build();
        Response loginResponse = loginClient.newCall(loginRequest).execute();
        // 获取头部
        Headers loginRsultHeaders = loginResponse.headers();
        // 获取身体信息
        String loginRsultBody = loginResponse.body().string();
        JSONObject loginJoRsultBody = JSONObject.parseObject(loginRsultBody);
        System.out.println(loginJoRsultBody.getJSONObject("data").get("token"));
        String ccToken= JSON.toJSONString(loginJoRsultBody.getJSONObject("data").get("token"));
        Assert.assertNotNull(ccToken);

        //等待2秒
        Thread.sleep(2000);

        //获取ccToken
        OkHttpClient ccTokenClient = new OkHttpClient().newBuilder().build();
        MediaType ccTokenMediaType = MediaType.parse("application/json,text/plain");
        RequestBody ccTokenBody = RequestBody.create(ccTokenMediaType, "{\r\n\t\"ccUserId\": \"115364\",\r\n\t\"ccToken\": "+ccToken+"\r\n}");
        Request ccTokenRequest = new Request.Builder()
                .url("https://luckytime.lerjin.com/user/login")
                .method("POST", ccTokenBody)
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Type", "text/plain")
                .build();
        Response ccTokenResponse = ccTokenClient.newCall(ccTokenRequest).execute();
        // 获取头部
        Headers ccTokenRsultHeaders = ccTokenResponse.headers();
        // 获取身体信息
        String ccTokenRsultBody = ccTokenResponse.body().string();
        JSONObject ccTokenJoRsultBody = JSONObject.parseObject(ccTokenRsultBody);
        System.out.println(ccTokenJoRsultBody.getJSONObject("data").get("token"));
        String token= JSON.toJSONString(ccTokenJoRsultBody.getJSONObject("data").get("token"));
        Assert.assertNotNull(token);

        CcToken ctcoken = new CcToken();
        ctcoken.setCreationTime(new Date());
        ctcoken.setSystemCode("德州扑克");
        ctcoken.setToken(token);
        ccTokenMapper.insert(ctcoken);
        return null;
    }
}
