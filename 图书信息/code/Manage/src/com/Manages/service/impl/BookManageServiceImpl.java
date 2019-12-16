package com.Manages.service.impl;

import com.Manages.dao.BookManageDao;
import com.Manages.dao.impl.BookManageDaoImpl;
import com.Manages.entity.BookManage;
import com.Manages.service.BookManageService;
import com.Manages.util.BaseDaoUtil;

import java.sql.SQLException;
import java.util.List;

public class BookManageServiceImpl implements BookManageService {


    @Override
    public List<BookManage> getAllBook() throws SQLException {
        BookManageDao bookManageDao = new BookManageDaoImpl(BaseDaoUtil.getConnection());
        List<BookManage> list = bookManageDao.getAllBook();
        BaseDaoUtil.colseAll(BaseDaoUtil.getConnection(), null, null);
        return list;
    }

    @Override
    public int delBookManage(int id) throws SQLException {
        BookManageDao bookManageDao = new BookManageDaoImpl(BaseDaoUtil.getConnection());
        int i = bookManageDao.delBookManage(id);
        BaseDaoUtil.colseAll(BaseDaoUtil.getConnection(), null, null);
        return i;
    }
}
