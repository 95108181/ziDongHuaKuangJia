package test.service.servicePhone;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
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


    public static void takeScreenShot(AndroidDriver driver) {
        File screenShotFile = driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File("D:\\AutomaticScreenshot\\" + getCurrentDateTime() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCurrentDateTime() {
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return df.format(new Date());
    }


}
