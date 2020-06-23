package com.ceshi.scheduled;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ceshi.dao.CcTokenMapper;
import com.ceshi.dao.TestDataDao;
import com.ceshi.dao.TimingTaskMapper;
import com.ceshi.entity.CcToken;
import com.ceshi.entity.TimingTask;
import com.ceshi.util.SendHttps;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import test.TestngRun;
import test.controller.TestCCapp;
import test.controller.TestPhone;
import test.util.LogPrinting;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    TimingTaskMapper timingTaskMapper;


    //添加定时任务1
//    @Scheduled(cron = "*/5 * * * * ?") // 每5秒执行一次
//    public void scheduler() throws Exception {
//        TestngRun testngRun = new TestngRun();
//        testngRun.run();
//        logger.info("定时执行测试任务");
//    }


    /**
     * 添加定时任务,获取登录token userid  视频id
     *
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
//    @Scheduled(cron = "30 10 * * * ?") // 每小时的10分30秒触发任务
    @Scheduled(cron = "0 */6 * * * ?")
    public String getVerificationCode() throws IOException, InterruptedException {

        //获取验证码
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json,text/plain");
        RequestBody body = RequestBody.create(mediaType,
                "{\r\n    \"areaCode\": 86,\r\n    \"phone\" : 17323226097,\r\n    \"verifyType\" : 4\r\n}");
        Request request = new Request.Builder()
                .url("https://api.testing.clipclaps.tv/sms/verify")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Type", "text/plain")
                .build();

        //发送请求
        Response response = client.newCall(request).execute();

        // 获取头部
        Headers rsultHeaders = response.headers();

        // 获取身体信息
        String rsultBody = response.body().string();
        JSONObject joRsultBody = JSONObject.parseObject(rsultBody);
        logger.info("验证码数据：" + joRsultBody);

        //判断是否为空
        System.out.println(joRsultBody.getJSONObject("data").get("verifyCode"));
        String verifyCode = JSON.toJSONString(joRsultBody.getJSONObject("data").get("verifyCode"));
        Assert.assertNotNull(verifyCode);

        //等待2秒
        Thread.sleep(2000);

        //获取ccToken
        OkHttpClient loginClient = new OkHttpClient().newBuilder().build();
        MediaType loginMediaType = MediaType.parse("application/json,text/plain");
        RequestBody loginBody = RequestBody.create(loginMediaType,
                "{\r\n\t\"areaCode\":86,\r\n\t\"phone\":17323226097,\r\n\t\"verifyCode\":" + verifyCode + "\r\n}");
        Request loginRequest = new Request.Builder()
                .url("https://api.testing.clipclaps.tv/account/login")
                .method("POST", loginBody)
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Type", "text/plain")
                .build();
        logger.info("请求数据：" + loginRequest);

        //发送请求
        Response loginResponse = loginClient.newCall(loginRequest).execute();


        // 获取头部
        Headers loginRsultHeaders = loginResponse.headers();
        logger.info("获取头部返回数据：" + loginRsultHeaders);

        // 获取身体信息
        String loginRsultBody = loginResponse.body().string();
        logger.info("获取身体信息返回数据：" + loginRsultBody);

        JSONObject loginJoRsultBody = JSONObject.parseObject(loginRsultBody);
        System.out.println(loginJoRsultBody.getJSONObject("data").get("token"));
        String ccToken = JSON.toJSONString(loginJoRsultBody.getJSONObject("data").get("token"));
        String userid = JSON.toJSONString(loginJoRsultBody.getJSONObject("data").getJSONObject("principal").get("userid"));
        logger.info(ccToken + "============================" + userid);

        //判断是否为null
        Assert.assertNotNull(ccToken);


        //等待2秒
        Thread.sleep(2000);
        String strToken = ccToken.replace("\"", "");
        String strUserid = userid.replace("\"", "");
        logger.info("去掉双引号的strToken：" + strToken);


        OkHttpClient Videoclient = new OkHttpClient().newBuilder()
                .build();
        MediaType VideomediaType = MediaType.parse("text/plain");
        //线下
        RequestBody Videobody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("videoTitle", "视频上传测试")
                .addFormDataPart("videoDescribe", "ldaskdlaskjldkjksald")
                .addFormDataPart("file", System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"ceshishiping.mp4",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File(System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"ceshishiping.mp4")))
                .build();

        //线上
//        RequestBody Videobody = new MultipartBody.Builder().setType(MultipartBody.FORM)
//                .addFormDataPart("videoTitle", "视频上传测试")
//                .addFormDataPart("videoDescribe", "ldaskdlaskjldkjksald")
//                .addFormDataPart("file", System.getProperty("user.dir")+ File.separator+"ceshishiping.mp4l",
//                        RequestBody.create(MediaType.parse("application/octet-stream"),
//                                new File(System.getProperty("user.dir")+ File.separator+"ceshishiping.mp4l")))
//                .build();

        Request Videorequest = new Request.Builder()
                .url("https://ugc.ccdev.lerjin.com/video/upload")
                .method("POST", Videobody)
                .addHeader("token", strToken)
                .addHeader("lang", "CN")
                .addHeader("userId", strUserid)
                .addHeader("module", "ugc")
                .build();
        LogPrinting.log("request数据", Videorequest);
        Response Videoresponse = Videoclient.newCall(Videorequest).execute();

        // 获取头部
        Headers VideorsultHeaders = Videoresponse.headers();
        // 获取身体信息
        String VideorsultBody = Videoresponse.body().string();
        logger.info("视频上传返回参数：" + VideorsultBody);


        String VideoId = VideorsultBody.substring(7, 39);
        System.out.println(VideoId);

        String strVideoId = VideoId.replace("\"", "");
        logger.info("视频ID：" + strVideoId);


        //把tcoken和userID值存入数据库
        CcToken ctcoken = new CcToken();
        ctcoken.setCreationTime(new Date());
        ctcoken.setSystemCode("CCapp");
        ctcoken.setUserIdToken(strUserid);
        ctcoken.setToken(strToken);
        ctcoken.setVideoId(strVideoId);
        ccTokenMapper.insert(ctcoken);
        return null;
    }

    /**
     * 添加定时任务每分钟执行一次
     * @throws Exception
     */
//    @Scheduled(cron = "0 */1 * * * ?")
//    public void setupTime() throws Exception {
//        //获取当前时间转换为字符串
//        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
//        String strDate = sdf.format(new Date());
//        //查询出所有的定时任务数据
//        List<TimingTask> timingTaskList = timingTaskMapper.findAll();
//        //遍历数据判断是否与当前时间相等
//        for (int i = 0; i < timingTaskList.size(); i++) {
//            if ((timingTaskList.get(i).getTimingTask()).equals(strDate)) {
//                //执行测试任务
//                TestngRun.run();
//                logger.info("定时执行测试任务");
//                //删除已执行的定时任务数据
//                timingTaskMapper.delete(timingTaskList.get(i).getId());
//            } else {
//                logger.info("没有可定时执行的测试任务");
//            }
//        }
//
//    }


    /**
     * 添加定时任务,自动化
     *
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    @Scheduled(cron = "0 */3 * * * ?")
    public String dezhouAutomation() throws Exception {
        logger.info("自动化执行的测试任务");
        TestngRun.run();


        // 钉钉的webhook
        String dingDingToken="https://oapi.dingtalk.com/robot/send?access_token=b398045b402d44fd72cbffde505ccaab96080cb3e82e9dfd24bdb4ae587f1e25";
        //获取当前时间转换为字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(new Date());
        // 请求的JSON数据，这里我用map在工具类里转成json格式
        Map<String,Object> json=new HashMap();
        Map<String,Object> text=new HashMap();
        json.put("msgtype","markdown");
        text.put("title","测试报告");
        text.put("text","#### 测试 \n 测试case推送(试运行) \n ###### ["+strDate+"测试报告点击查看](http://47.105.49.229:8080/user/loading) \n ###### 账号:admin 密码：123456 \n");
        json.put("markdown",text);
        // 发送post请求
        String response = SendHttps.sendPostByMap(dingDingToken, json);
        System.out.println(response);

        return null;
    }
}
