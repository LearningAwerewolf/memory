package com.RainManages.servlet;

import com.RainManages.entity.RainManage;
import com.RainManages.service.RainManageService;
import com.RainManages.service.impl.RainManageServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RainManageservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        RainManageService service = new RainManageServiceImpl();
        PrintWriter out = resp.getWriter();
        if (flag.equals("list")) {
            List<RainManage> list = null;
            try {
                list = service.getAllRuain();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String json = JSON.toJSONStringWithDateFormat(list,"YYYY.MM.dd");
            out.println(json);
        } else if (flag.equals("del")) {
            //先获取集合
            int id = Integer.parseInt(req.getParameter("id"));
            int i = 0;
            try {
                i = service.delRainManage(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            out.println(i);
        } else if (flag.equals("add")) {
            RainManage rainManage = new RainManage();
            rainManage.setDistrictName(req.getParameter("txtName"));
            rainManage.setMonitoringAddress(req.getParameter("txtPlace"));
            rainManage.setMonitoringStation(req.getParameter("txtMonitor"));
            rainManage.setRain(Integer.parseInt(req.getParameter("txtRainValue")));

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
            ParsePosition pos = new ParsePosition(0);
            Date strtodate = sdf.parse(req.getParameter("txtTime"), pos);


            rainManage.setMonitorTime(strtodate);
            int i = 0;
            try {
                i = service.addRainManage(rainManage);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            out.println(i);
        }
        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
