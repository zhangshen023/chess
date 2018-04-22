package cn.lym77.db;

import cn.lym77.chess.domain.User;

import java.sql.*;

/**
 * @author shen
 * @version 1.0.0
 * @since 2018/4/21
 */
public class DbUtil {

    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/xiangqi?characterEncoding=utf-8";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "269123";

    public static User findUserByUserName(String userName) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * from t_user where user_name = '" + userName + "'";
            ResultSet rs = stmt.executeQuery(sql);

            User user = new User();
            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int userId = rs.getInt("user_id");
                String pwd = rs.getString("pwd");
                user.setUserId(userId);
                user.setPwd(pwd);
                user.setUserName(userName);
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
            return user;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 关闭资源
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static boolean regist(String userName, String pwd) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            stmt = conn.createStatement();
            String sql;
            sql = "insert into t_user (user_name,pwd) values ('" + userName + "','" + pwd + "')";
            stmt.execute(sql);

            // 完成后关闭
            stmt.close();
            conn.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // 关闭资源
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


}
