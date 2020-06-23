package test.service.serviceCCapp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ceshi.entity.CcToken;
import okhttp3.*;
import org.testng.Assert;
import org.testng.Reporter;
import test.util.CcTokenDB;
import test.util.LogPrinting;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 上传视频
 */
public class VideoUpload {
    /**
     * 上传视频
     * @return
     * @throws IOException
     */
    public static String videoUpload() throws IOException {

        //获取当前时间转换为字符串
        SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmm");
        String strDate = sdf.format(new Date());
        List<CcToken> ccTokenList= CcTokenDB.getAll();
        String userId = ccTokenList.get(0).getUserIdToken();
        LogPrinting.log("userId",userId);
        String token = ccTokenList.get(0).getToken();
        LogPrinting.log("token",token);


        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("videoTitle", "视频上传测试"+strDate)
                .addFormDataPart("videoDescribe", "ldaskdlaskjldkjksald")
                .addFormDataPart("file",System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"ceshishiping.mp4",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File(System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"ceshishiping.mp4")))
                .build();
        Request request = new Request.Builder()
                .url("https://ugc.ccdev.lerjin.com/video/upload")
                .method("POST", body)
                .addHeader("token", token)
                .addHeader("lang", "CN")
                .addHeader("userId", userId)
                .addHeader("module", "ugc")
                .build();
        LogPrinting.log("request数据",request);
        Response response = client.newCall(request).execute();

        // 获取头部
        Headers rsultHeaders = response.headers();
        // 获取身体信息
        String rsultBody = response.body().string();
        System.out.println(rsultBody.substring(7,39));

        LogPrinting.log("response数据",rsultBody);
//        JSONObject joRsultBody = JSONObject.parseObject(rsultBody);
//        String data= JSON.toJSONString(joRsultBody.getJSONObject("id"));
        Assert.assertNotNull(rsultBody.substring(7,39).replace("\"", ""));
        return null;
    }
}
