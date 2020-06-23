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
//        String dingDingToken="https://oapi.dingtalk.com/robot/send?access_token=e1f48febfab20962dab549a92f782011f7d165937ebd2dfaf58f17a5173eaf48";
        String dingDingToken="https://oapi.dingtalk.com/robot/send?access_token=b398045b402d44fd72cbffde505ccaab96080cb3e82e9dfd24bdb4ae587f1e25";
        // 请求的JSON数据，这里我用map在工具类里转成json格式
        Map<String,Object> json=new HashMap();
        Map<String,Object> text=new HashMap();
        json.put("msgtype","markdown");
        text.put("title","测试");
        text.put("text","# 测试 \n> 智能机器人推送 \n> ![](https://wangqioss.oss-cn-beijing.aliyuncs.com/CCpicture/1589382512547.png?Expires=1904742506&OSSAccessKeyId=LTAI4Fh3gTdTRL5vcnjQJfs7&Signature=dwyZqypYU2PEgxWck5RpBDAkpkk%3D)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      [链接](https://www.dingtalk.com) \n");
        json.put("markdown",text);
        // 发送post请求
        String response = SendHttps.sendPostByMap(dingDingToken, json);
        System.out.println("相应结果："+response);

    }
}
