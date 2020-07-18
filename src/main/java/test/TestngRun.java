package test;

import com.beust.jcommander.internal.Lists;
import com.ceshi.util.SendHttps;
import org.springframework.web.multipart.MultipartFile;
import org.testng.TestNG;/**/
import test.service.servicePhone.BaseService;
import test.util.OssUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestngRun {
    /**
     * 获取TestNG的xml,并执行测试代码
     */
    public static void run() {
        TestNG testng = new TestNG();
        //获取TestNG的xml的地址
        List suites = Lists.newArrayList();
        //本地地址
//        suites.add(System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"testng.xml");
        //线上地址
        suites.add(System.getProperty("user.dir")+ File.separator+"testng.xml");
        testng.setTestSuites(suites);
        //执行测试代码
        testng.run();
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
//        TestNG testng = new TestNG();
//        List suites = Lists.newArrayList();
//        //path to xml..
//        suites.add("F:\\IDEAproject\\cheShideom\\src\\main\\resources\\testng.xml");
//        testng.setTestSuites(suites);
//        testng.run();



    }


}
