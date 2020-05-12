package test.service.servicePhone;


//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class TexasHoldemPhone {
//
//    public static void main(String[] args) throws InterruptedException, MalformedURLException {
//        TexasHoldemPhone appium = new TexasHoldemPhone();
//        appium.texasHoldemPhone();
//    }
//    /**
//     * 德州扑克自动化
//     * @return
//     * @throws
//     */
//    public static String texasHoldemPhone() throws MalformedURLException, MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("deviceName", "MR4PJJMVZDORWG9H");
//        capabilities.setCapability("automationName", "Appium");
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("platformVersion", "8.1.0");
//        capabilities.setCapability("appPackage", "com.sanhe.clipclaps");
//        capabilities.setCapability("appActivity", ".ui.activity.GuideActivity");
//        //appium提供的一种输入法，可以传中文。测试时直接用这个输入法
////    capabilities.setCapability("unicodeKeyboard", "True");
//        //程序结束时重置原来的输入法
////    capabilities.setCapability("resetKeyboard", "True");
//        //不初始化手机app信息（类似不清楚缓存）
//        capabilities.setCapability("noReset", "True");
//        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//
//
////        try {
//            double Screen_X = driver.manage().window().getSize().width;//获取手机屏幕宽度
//            double Screen_Y = driver.manage().window().getSize().height;//获取手机屏幕高度
//            System.out.println(Screen_X + "---------------------" + Screen_Y);
////            sleep(8000);
////            for (int i = 0; i <= 0; i = 9) {
////                //模拟手指点击操作
////                driver.tap(1, 300, 900, 500);
////                sleep(700);
////                //模拟手指点击操作
////                driver.swipe(500, 1500, 500, 400, 1000);
////                sleep(7000);
////            }
////        } catch (Exception e) {
////            System.out.println("报错：" + e);
////        } finally {
////            System.out.println("结束");
////        }
//        return null;
//    }
//}
