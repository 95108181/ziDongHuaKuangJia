package test.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ceshi.entity.CcToken;
import okhttp3.*;
import org.testng.Assert;
import org.testng.Reporter;
import test.util.CcTokenDB;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class ReceiveUpgradeAward {
    /**
     * 领取升级奖励
     * @return
     * @throws IOException
     */
    public static String receiveUpgradeAward() throws IOException {
        //获取当前时间转换为字符串
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
        String strDate = sdf.format(new Date());
        List<CcToken> ccTokenList= CcTokenDB.getAll();
        String token = ccTokenList.get(0).getToken();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json,text/plain");
        RequestBody body = RequestBody.create(mediaType, "{\r\n\t\"levels\":[30]\r\n}");
        Request request = new Request.Builder()
                .url("https://luckytime.lerjin.com/holdem/user/level/award/collect")
                .method("POST", body)
                .addHeader("token", token)
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Type", "text/plain")
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
