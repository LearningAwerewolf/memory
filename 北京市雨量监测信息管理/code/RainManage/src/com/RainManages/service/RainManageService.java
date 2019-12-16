package com.RainManages.service;

import com.RainManages.entity.RainManage;

import java.sql.SQLException;
import java.util.List;

public interface RainManageService {

    public List<RainManage> getAllRuain() throws SQLException;

    public int addRainManage(RainManage rainManage) throws SQLException;

    public int delRainManage(int id) throws SQLException;






}
