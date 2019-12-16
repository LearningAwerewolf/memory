package com.Manages.dao;

import com.Manages.util.BaseDaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {

    private Connection conn;

    public BaseDao(Connection conn) {
        this.conn = conn;
    }

    /**
     * 增、删、改操作
     *
     * @param sql    sql语句
     * @param params 参数数组
     * @return 执行结果
     * @throws SQLException
     */
    protected int executeUpdate(String sql, Object[] params) throws SQLException {
        int result = 0;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            BaseDaoUtil.colseAll(null, pstmt, null);
        }
        return result;
    }

    /**
     * 查询操作
     *
     * @param sql    sql语句
     * @param params 参数数组
     * @return 查询结果集
     * @throws SQLException
     */
    protected ResultSet executeQuery(String sql, Object[] params) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }

            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return rs;
    }
}
