package com.RainManages.dao.impl;

import com.RainManages.dao.BaseDao;
import com.RainManages.dao.RainManageDao;
import com.RainManages.entity.RainManage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RainManageDaoImpl extends BaseDao implements RainManageDao {
    public RainManageDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public List<RainManage> getAllRuain() throws SQLException {
        ResultSet resultSet = null;
        List<RainManage> list = new ArrayList<RainManage>();
        String sql = "select * FROM rainQuality";
        resultSet = super.executeQuery(sql, null);
        if (resultSet != null) {
            while (resultSet.next()) {
                RainManage rainManage = new RainManage();
                rainManage.setId(resultSet.getInt("id"));
                rainManage.setDistrictName(resultSet.getString("districtName"));
                rainManage.setMonitorTime(resultSet.getDate("monitorTime"));
                rainManage.setRain(resultSet.getInt("rain"));
                rainManage.setMonitoringStation(resultSet.getString("monitoringStation"));
                rainManage.setMonitoringAddress(resultSet.getString("monitoringAddress"));
                list.add(rainManage);
            }
        }

        return list;
    }

    @Override
    public int addRainManage(RainManage rainManage) throws SQLException {
        String sql = "insert into rainQuality(districtName,monitorTime,rain,monitoringStation,monitoringAddress) values(?,?,?,?,?) ";
        Object[] params = {rainManage.getDistrictName(), rainManage.getMonitorTime(), rainManage.getRain(),rainManage.getMonitoringStation(),rainManage.getMonitoringAddress()};
        int num = super.executeUpdate(sql, params);
        return num;
    }

    @Override
    public int delRainManage(int id) throws SQLException {
        String sql = "DELETE FROM rainQuality WHERE id =?";
        Object[] params = {id};
        int num = executeUpdate(sql, params);
        return num;
    }
}
