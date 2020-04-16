package test;

import com.beust.jcommander.internal.Lists;
import org.testng.TestNG;/**/
import java.io.File;
import java.util.List;

public class TestngRun {
    /**
     * 获取TestNG的xml,并执行测试代码
     */
    public static void run() {
        TestNG testng = new TestNG();
        //获取TestNG的xml的地址
        List suites = Lists.newArrayList();
        suites.add(System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"testng.xml");
        testng.setTestSuites(suites);
        //执行测试代码
        testng.run();
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        List suites = Lists.newArrayList();
        suites.add("F:\\IDEAproject\\cheShideom\\src\\main\\resources\\testng.xml");//path to xml..
        testng.setTestSuites(suites);
        testng.run();
    }


}
