package test.service;

import com.alibaba.fastjson.JSON;
import com.ceshi.entity.CcToken;
import okhttp3.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import test.util.CcTokenDB;

import java.io.IOException;
import java.util.List;

public class UserInformation {
    /**
     * 用户信息
     * @return
     * @throws IOException
     */
    public static String userInformation() throws IOException {
        List<CcToken> ccTokenList= CcTokenDB.getAll();
        String token = ccTokenList.get(0).getToken();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://luckytime.lerjin.com/holdem/user/info")
                .method("POST", body)
                .addHeader("token", token)
                .build();
        Response response = client.newCall(request).execute();

        // 获取头部
        Headers rsultHeaders = response.headers();
        // 获取身体信息
        String rsultBody = response.body().string();
        JSONObject joRsultBody = JSONObject.parseObject(rsultBody);
        String nickname= JSON.toJSONString(joRsultBody.getJSONObject("data").get("nickname"));
        Assert.assertNotNull(nickname);
        return null;
    }
}
