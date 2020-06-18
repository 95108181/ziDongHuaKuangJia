package test.util;

import org.testng.Reporter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * name:wq
 * date:2020年6月16日15:28:49
 */
public class LogPrinting {
    /**
     * 自动化日志打印
     *
     * @param parameterName
     * @param parameter
     */
    public static void log(Object parameterName, Object parameter) {
        //获取当前时间转换为字符串
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
        String strDate = sdf.format(new Date());
        //转字符串
        String name = parameterName.toString();
        String log = parameter.toString();
        //打印日志
        Reporter.log(strDate + ":" + name);
        Reporter.log(strDate + ":" + log.replace("\"", ""));
        System.out.println(name);
        System.out.println(log.replace("\"", ""));
    }
}
