package test.service.servicePhone;

import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import static java.lang.Thread.sleep;


/**
 * @author wq
 */
public class TexasHoldemPhone {
    /**
     * 德州扑克自动化
     *
     * @throws
     */
    public static void texasHoldemPhone() throws MalformedURLException {
//        AndroidDriver driver = BaseService.phoneInformation();
        try {
//            //获取手机屏幕宽度
//            double Screen_X = driver.manage().window().getSize().width;
//            //获取手机屏幕高度
//            double Screen_Y = driver.manage().window().getSize().height;
//            System.out.println(Screen_X + "---------------------" + Screen_Y);
//            //模拟用户操作
//            driver.findElement(BaseService.findById(driver, By.id("com.sanhe.clipclaps:id/pre_debug"))).click();
//            driver.findElement(BaseService.findById(driver, By.xpath("(//android.widget.ImageView[@content-desc=\"icon\"])[3]"))).click();
//            driver.findElement(BaseService.findById(driver, By.id("com.sanhe.clipclaps:id/mGameBannerView"))).click();
//            driver.findElement(BaseService.findById(driver, By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget." +
//                    "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget." +
//                    "LinearLayout/androidx.recyclerview.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.ImageView")))
//                    .click();
//            sleep(7000);
//            String imgFile = BaseService.takeScreenShot(driver);
            String imgFile = "D:\\AutomaticScreenshot\\2020513191105.png";
            String imgBase64 = BaseService.ImageToBase64ByLocal(imgFile);
            System.out.println(imgBase64);
        } catch (Exception e) {
//            driver.closeApp();
//            driver.quit();
            System.out.println("报错：" + e);
        } finally {
//            driver.closeApp();
//            driver.quit();
            System.out.println("结束");
        }
    }
}
