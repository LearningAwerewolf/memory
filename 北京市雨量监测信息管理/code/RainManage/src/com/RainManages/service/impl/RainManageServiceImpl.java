package com.RainManages.service.impl;

import com.RainManages.dao.RainManageDao;
import com.RainManages.dao.impl.RainManageDaoImpl;
import com.RainManages.entity.RainManage;
import com.RainManages.service.RainManageService;
import com.RainManages.util.BaseDaoUtil;

import java.sql.SQLException;
import java.util.List;

public class RainManageServiceImpl implements RainManageService {
    @Override
    public List<RainManage> getAllRuain() throws SQLException {
        RainManageDao rainManageDao = new RainManageDaoImpl(BaseDaoUtil.getConnection());
        List<RainManage> list = rainManageDao.getAllRuain();
        BaseDaoUtil.colseAll(BaseDaoUtil.getConnection(), null, null);
        return list;
}

    @Override
    public int addRainManage(RainManage rainManage) throws SQLException {
        RainManageDao rainManageDao = new RainManageDaoImpl(BaseDaoUtil.getConnection());
        int i = rainManageDao.addRainManage(rainManage);
        return i;
    }

    @Override
    public int delRainManage(int id) throws SQLException {
        RainManageDao rainManageDao = new RainManageDaoImpl(BaseDaoUtil.getConnection());
        int i = rainManageDao.delRainManage(id);
        return i;
    }
}
