package com.Manages.util;

import java.sql.*;

/**
 * Created by rcy on 2019/12/4.
 */
public class BaseDaoUtil {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=utf-8";
    private static String user = "root";//数据库用户名
    private static String pwd = "154057";//数据库密码

    //加载驱动
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回数据库链接对象（开）
     *
     * @return
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭所有链接（关）
     *
     * @param conn
     * @param st
     * @param rs
     */
    public static void colseAll(Connection conn, Statement st, ResultSet rs) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (st != null && !st.isClosed()) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
