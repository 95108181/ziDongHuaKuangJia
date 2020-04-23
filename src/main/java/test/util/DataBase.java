package test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static final String URL = "jdbc:mysql://47.96.233.196:3306/wangqicheshitestng?useUnicode=true&characterEncoding=utf8&autoReconnect=true";
    private static final String UNAME = "root";
    private static final String PWD = "123456";
    private static Connection conn = null;

    static {

        try {
            // 1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.获得数据库的连接
            conn = DriverManager.getConnection(URL, UNAME, PWD);
        } catch (ClassNotFoundException e) {e.printStackTrace();} catch (SQLException e) {e.printStackTrace();}
    }

    public static Connection getConnection() {return conn;}

}