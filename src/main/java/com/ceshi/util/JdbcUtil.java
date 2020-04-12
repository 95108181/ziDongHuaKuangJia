package com.ceshi.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class JdbcUtil {
  private static TestMail testMail;
  private static Logger LOG = LoggerFactory.getLogger(JdbcUtil.class);
  private final static String DriverName = "oracle.jdbc.OracleDriver";
  private final static String URL = "jdbc:oracle:thin:@192.168.0.73:1521:orcl";
  private final static String USERNAME = "ceshi";
  private final static String PASSWORD = "123456";
  public static Map select(Map<String, String> map) throws Exception {
    Map<String, String> sqlJieGuo = new HashMap<String, String>();
    //1.注ce驱动
    Class.forName(DriverName);
    //2.获取连接
    Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    String sql = map.get("sql");
    LOG.info("执行参数sql : " +map.get("sql"));
    //4.创建发送对象
    Statement stmt = conn.createStatement();
    //5.发送sql语句
    ResultSet rs = stmt.executeQuery(sql);
    //6.处理结果集
    while (rs.next()) {
      sqlJieGuo.put("sqlYanZhen",rs.getString("login_name"));
      LOG.info("用户名为 : " +rs.getString("login_name"));
    }
    //7.关闭资源
    rs.close();
    stmt.close();
    conn.close();
    return sqlJieGuo;
  }
}