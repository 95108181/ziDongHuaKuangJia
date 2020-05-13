package test.service;

import java.io.IOException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ceshi.entity.CcToken;
import okhttp3.*;
import org.testng.Assert;
import org.testng.Reporter;
import test.util.CcTokenDB;


public class QuerySeasonSettlementRewards {
    /**
     * 查询赛季结算奖励
     * @return
     * @throws IOException
     */
    public static String querySeasonSettlementRewards() throws IOException {
        //获取当前时间转换为字符串
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
        String strDate = sdf.format(new Date());
        List<CcToken> ccTokenList= CcTokenDB.getAll();
        String token = ccTokenList.get(0).getToken();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://luckytime.lerjin.com/holdem/season/settle")
                .method("POST", body)
                .addHeader("token", token)
                .build();
        Response response = client.newCall(request).execute();

        // 获取头部
        Headers rsultHeaders = response.headers();
        // 获取身体信息
        String rsultBody = response.body().string();
        JSONObject joRsultBody = JSONObject.parseObject(rsultBody);
        String code= JSON.toJSONString(joRsultBody.get("code"));
        //断言
        Assert.assertNotNull(code);

        Reporter.log(strDate +":"+"打印的日志");
        Reporter.log(strDate +":"+rsultBody.replace("\"", ""));
        return null;
    }
}
