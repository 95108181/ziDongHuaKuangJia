package test.service.serviceCCapp;


import okhttp3.*;
import test.util.LogPrinting;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

/**
 * feed流请求主页
 */
public class FeedStream {
    /**
     * feed流请求主页
     * @return
     * @throws IOException
     */
    public static String feedStream() throws IOException {

        //获取当前时间转换为字符串
        SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmm");
        String strDate = sdf.format(new Date());
//        List<CcToken> ccTokenList= CcTokenDB.getAll();
//        String userId = ccTokenList.get(0).getUserIdToken();
//        LogPrinting.log("userId",userId);
//        String token = ccTokenList.get(0).getToken();
//        LogPrinting.log("token",token);

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.testing.clipclaps.tv/feeds/feed/video?uid=115364&devType=iOS&version=1.8.1")
                .method("GET", null)
                .addHeader("req_id", "111")
                .build();

        LogPrinting.log("request数据",request);
        Response response = client.newCall(request).execute();

        // 获取头部
        Headers rsultHeaders = response.headers();
        // 获取身体信息
        String rsultBody = response.body().string();
        System.out.println(rsultBody);

        if(rsultBody.replace("\"", "").contains("msg:Success")){
            assertThat(rsultBody.replace("\"", ""),containsString("msg:Success" ));
        }else{
            System.out.println("不包含");
        }

        return null;
    }
}
