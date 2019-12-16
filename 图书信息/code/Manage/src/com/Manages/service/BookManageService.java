package com.Manages.service;

import com.Manages.entity.BookManage;

import java.sql.SQLException;
import java.util.List;

public interface BookManageService {

    public List<BookManage> getAllBook() throws SQLException;

    public int delBookManage(int id) throws SQLException;





}
