package com.ceshi.util;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhouhe
 * @Date: 2019/6/20 14:52
 */
public class SendMessage {
    public static void main(String[] args){

        // 钉钉的webhook
        String dingDingToken="https://oapi.dingtalk.com/robot/send?access_token=e1f48febfab20962dab549a92f782011f7d165937ebd2dfaf58f17a5173eaf48";
        // 请求的JSON数据，这里我用map在工具类里转成json格式
        Map<String,Object> json=new HashMap();
        Map<String,Object> text=new HashMap();
        json.put("msgtype","text");
        text.put("content","告警消息-自动化用例-试运行结果：http://47.105.49.229:8080/testData/details/534");
        json.put("text",text);
        // 发送post请求
        String response = SendHttps.sendPostByMap(dingDingToken, json);
        System.out.println("相应结果："+response);

    }
}
