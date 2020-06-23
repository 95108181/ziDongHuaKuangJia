package test.service.servicePhone;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Thread.sleep;


/**
 * 公用方法类
 *
 * @author wq
 */
public class BaseService {

    /**
     * 获取手机信息
     *
     * @return
     * @throws MalformedURLException
     */
    public static AndroidDriver phoneInformation() throws MalformedURLException {

        //DesiredCapabilities参数配置
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("deviceName", "MR4PJJMVZDORWG9H");
        capabilities.setCapability("deviceName", "HYK79SSK45CQLB5L");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.1.0");
        capabilities.setCapability("appPackage", "com.sanhe.clipclaps");
        capabilities.setCapability("appActivity", ".ui.activity.GuideActivity");

        //appium提供的一种输入法，可以传中文。测试时直接用这个输入法
        //capabilities.setCapability("unicodeKeyboard", "True");
        //程序结束时重置原来的输入法
        //capabilities.setCapability("resetKeyboard", "True");

        //不初始化手机app信息（类似不清楚缓存）
        capabilities.setCapability("noReset", "True");
        //AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    /**
     * 判断选择器是否为空
     *
     * @param driver
     * @param seletor
     * @throws InterruptedException
     */
    public static By findById(AndroidDriver driver, By seletor) throws InterruptedException {
        //循环遍历查看选择器是否存在
        int a = 10;
        for (int i = 0; i < a; i++) {
            sleep(2000);
            System.out.println("循环" + i + "次找" + seletor);
            try {
                if (driver.findElement(seletor).isEnabled()) {
                    i = a;
                }
            } catch (Exception e) {
                System.out.println("不存在此元素" + seletor);
            }
        }
        return seletor;
    }


    public static String takeScreenShot(AndroidDriver driver) {
        File screenShotFile = driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File("D:\\AutomaticScreenshot\\" + getCurrentDateTime() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "D:\\AutomaticScreenshot\\" + getCurrentDateTime() + ".jpg";
    }

    public static String getCurrentDateTime() {
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return df.format(new Date());
    }

    /**
     * 本地图片转换成base64字符串
     *
     * @param imgFile 本地图片全路径 （注意：带文件名）
     *                (将图片文件转化为字节数组字符串，并对其进行Base64编码处理)
     * @return
     */
    public static String ImageToBase64ByLocal(String imgFile) {


        byte[] data = null;

        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgFile);

            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 返回Base64编码过的字节数组字符串
        return Base64Utils.encodeToString(data);
    }

    /**
     * base64字符串转换成图片 (对字节数组字符串进行Base64解码并生成图片)
     *
     * @param imgStr      base64字符串
     * @param imgFilePath 指定图片存放路径  （注意：带文件名）
     * @return
     */
    public static boolean Base64ToImage(String imgStr, String imgFilePath) {
        // 图像数据为空
        if (StringUtils.isEmpty(imgStr)) {
            return false;
        }
        try {
            // Base64解码
            byte[] b = Base64Utils.decodeFromString(imgStr);
            for (int i = 0; i < b.length; ++i) {
                // 调整异常数据
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }

            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    //本地文件转为MultipartFile类型(文件路径)
    public static MultipartFile getMulFileByPath(String picPath) {
        FileItem fileItem = createFileItem(picPath);
        MultipartFile mfile = new CommonsMultipartFile(fileItem);
        return mfile;
    }

    private static FileItem createFileItem(String filePath)
    {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        String textFieldName = "textField";
        int num = filePath.lastIndexOf(".");
        String extFile = filePath.substring(num);
        FileItem item = factory.createItem(textFieldName, "text/plain", true,
                "MyFileName" + extFile);
        File newfile = new File(filePath);
        long fileSize = newfile.length();
        int bytesRead = 0;
        byte[] buffer =new byte[(int) fileSize];
        try
        {
            FileInputStream fis = new FileInputStream(newfile);
            OutputStream os = item.getOutputStream();
            while ((bytesRead = fis.read(buffer, 0,  buffer.length))!= -1)
            {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            fis.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return item;
    }


}
