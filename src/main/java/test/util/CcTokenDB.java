package test.util;

import com.ceshi.entity.CcToken;
import com.ceshi.entity.TestData;
import org.springframework.jdbc.support.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据层处理类
 *
 * @author AlanLee
 */
public class CcTokenDB {
    /**
     * 查询数据
     *
     * @throws SQLException
     */
    public static List<CcToken> getAll() {
        // 获得数据库连接
        Connection conn = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;

        try {
            conn = DataBase.getConnection();

            String sql = "SELECT * FROM cc_token where system_code = 'CCapp' order by creation_time desc";
            ptmt = conn.prepareStatement(sql);
            rs = ptmt.executeQuery();
            List<CcToken> ccTokenList = new ArrayList<>();
            while (rs.next()) {
                CcToken ccToken = new CcToken();
                ccToken.setToken(rs.getString("token"));
                ccToken.setUserIdToken(rs.getString("userId_Token"));
                ccToken.setVideoId(rs.getString("video_id"));
                ccTokenList.add(ccToken);
            }
            return ccTokenList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null) {
                    ptmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
