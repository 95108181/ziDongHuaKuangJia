package test.service.serviceCCapp;

import com.ceshi.entity.CcToken;
import okhttp3.*;
import org.junit.Assert;
import test.util.CcTokenDB;
import test.util.LogPrinting;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * 视频播放
 */
public class VideoPlayback {
    /**
     * 视频播放
     * @return
     * @throws IOException
     */
    public static String videoPlayback() throws IOException {

        //获取当前时间转换为字符串
        SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmm");
        String strDate = sdf.format(new Date());

        //获取token和userId
        List<CcToken> ccTokenList= CcTokenDB.getAll();
        String userId = ccTokenList.get(0).getUserIdToken();
        LogPrinting.log("userId",userId);
        String token = ccTokenList.get(0).getToken();
        LogPrinting.log("token",token);
        String VideoId = ccTokenList.get(0).getVideoId();
        LogPrinting.log("VideoId",VideoId);


        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                "\r\n{\r\n\t\"eventType\":\"VIEW\",\r\n\t\"sourceId\":\""+VideoId+"\",\r\n\t\"pid\":\"eerj2i3123\",\r\n\t\"status\":\"0\",\r\n\t\"source\":\"0\",\r\n\t\"feedOrder\":\"0\",\r\n\t\"duration\":\"2\"\r\n}");
        Request request = new Request.Builder()
                .url("https://cpv.ccdev.lerjin.com/behavior/event")
                .method("POST", body)
                .addHeader("ostype", "ios")
                .addHeader("sysver", "13.4.1")
                .addHeader("apiver", "1")
                .addHeader("appver", "1.8.1")
                .addHeader("timezone", "8")
                .addHeader("lang", "CN")
                .addHeader("uuid", "11111111111111111111")
                .addHeader("token", token)
                .addHeader("userId", userId)
                .addHeader("Content-Type", "application/json")
                .build();
        LogPrinting.log("request数据",request);

        Response response = client.newCall(request).execute();

        // 获取头部
        Headers rsultHeaders = response.headers();
        // 获取身体信息
        String rsultBody = response.body().string();
        LogPrinting.log("response数据",rsultBody);

        Assert.assertNotNull(rsultBody.replace("\"", ""));
        Assert.assertEquals(rsultBody.replace("\"", ""), "true");


        return null;
    }
}
