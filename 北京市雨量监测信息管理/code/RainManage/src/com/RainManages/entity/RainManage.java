package com.RainManages.entity;

import java.util.Date;

public class RainManage {
    private int id;
    private int rain;
    private String districtName;
    private Date monitorTime;
    private String monitoringStation;
    private String monitoringAddress;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRain() {
        return rain;
    }

    public void setRain(int rain) {
        this.rain = rain;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Date getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(Date monitorTime) {
        this.monitorTime = monitorTime;
    }

    public String getMonitoringStation() {
        return monitoringStation;
    }

    public void setMonitoringStation(String monitoringStation) {
        this.monitoringStation = monitoringStation;
    }

    public String getMonitoringAddress() {
        return monitoringAddress;
    }

    public void setMonitoringAddress(String monitoringAddress) {
        this.monitoringAddress = monitoringAddress;
    }
}
