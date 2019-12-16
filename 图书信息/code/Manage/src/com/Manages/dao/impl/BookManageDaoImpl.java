package com.Manages.dao.impl;

import com.Manages.dao.BaseDao;
import com.Manages.dao.BookManageDao;
import com.Manages.entity.BookManage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookManageDaoImpl extends BaseDao implements BookManageDao {

    public BookManageDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public List<BookManage> getAllBook() throws SQLException {
        ResultSet resultSet = null;
        List<BookManage> list = new ArrayList<BookManage>();
        String sql = "select * FROM bookmanage";
        resultSet = super.executeQuery(sql, null);
        if (resultSet != null) {
            while (resultSet.next()) {
                BookManage bookManage = new BookManage();
                bookManage.setId(resultSet.getInt("b_id"));
                bookManage.setName(resultSet.getString("b_name"));
                bookManage.setTime(resultSet.getDate("b_time"));
                bookManage.setAuthor(resultSet.getString("b_author"));
                bookManage.setType(resultSet.getString("b_type"));
                list.add(bookManage);
            }
        }

        return list;
    }

    @Override
    public int delBookManage(int id) throws SQLException {
        String sql = "DELETE FROM bookmanage WHERE b_id =?";
        Object[] params = {id};
        int num = executeUpdate(sql, params);
        return num;
    }
}
