package com.RainManages.dao;

import com.RainManages.entity.RainManage;

import java.sql.SQLException;
import java.util.List;

public interface RainManageDao {
    /*A、编写查询方法，查询所有雨量监测信息，查询结果按照监测时间倒序排列
    B、编写添加方法，新增雨量监测信息
     C、编写删除方法，删除指定的雨量监测信息*/

    /**
     * ，查询所有雨量监测信息，查询结果按照监测时间倒序排列
     *
     * @return
     */
    public List<RainManage> getAllRuain() throws SQLException;

    public int addRainManage(RainManage rainManage) throws SQLException;

    public int delRainManage(int id) throws SQLException;

}
