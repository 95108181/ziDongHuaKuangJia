package test.util;

import com.ceshi.entity.TestData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 数据层处理类
 *
 * @author AlanLee
 */
public class TestDataDB {
    /**
     * 添加数据
     *
     * @throws SQLException
     */
    public static void addTestData(TestData testData) {
        // 获得数据库连接
        Connection conn = null;
        PreparedStatement ptmt = null;

        try {
            conn = DataBase.getConnection();

            String sql = "insert into test_data" +
                    "(test_pass,test_skip,test_all,tests_fail,start_time,running_time,case_name,case_result,creation_time,modification_time,is_it_deleted) " +
                    "values(?,?,?,?,?,?,?,?,?,?,?)";

            ptmt = conn.prepareStatement(sql);

            ptmt.setString(1, testData.getTestPass());
            ptmt.setString(2, testData.getTestSkip());
            ptmt.setString(3, testData.getTestAll());
            ptmt.setString(4, testData.getTestsFail());
            ptmt.setString(5, testData.getStartTime());
            ptmt.setString(6, testData.getRunningTime());
            ptmt.setString(7, testData.getCaseName());
            ptmt.setString(8, testData.getCaseResult());
            ptmt.setString(9, testData.getCreationTime());
            ptmt.setString(10, testData.getModificationTime());
            ptmt.setString(11, testData.getIsItDeleted());

            ptmt.execute();
        } catch (SQLException e) {e.printStackTrace();} finally {
            try {
                if (ptmt != null) { ptmt.close();}
            } catch (SQLException e) {e.printStackTrace();}
        }
    }




}
