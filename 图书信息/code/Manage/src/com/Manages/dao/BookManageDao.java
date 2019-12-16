package com.Manages.dao;

import com.Manages.entity.BookManage;

import java.sql.SQLException;
import java.util.List;

public interface BookManageDao {


    public List<BookManage> getAllBook() throws SQLException;

    public int delBookManage(int id) throws SQLException;

}
