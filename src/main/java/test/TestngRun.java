package test;

import com.beust.jcommander.internal.Lists;
import org.testng.TestNG;/**/

import java.io.File;
import java.util.List;

public class TestngRun {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        List suites = Lists.newArrayList();
        suites.add("F:\\IDEAproject\\cheShideom\\src\\main\\resources\\testng.xml");//path to xml..
        testng.setTestSuites(suites);
        testng.run();
    }

    public static void run() {
        TestNG testng = new TestNG();
        List suites = Lists.newArrayList();
        suites.add(System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"testng.xml");
        testng.setTestSuites(suites);
        testng.run();
    }

}
