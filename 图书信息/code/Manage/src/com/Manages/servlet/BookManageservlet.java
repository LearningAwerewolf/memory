package com.Manages.servlet;

import com.Manages.entity.BookManage;
import com.Manages.service.BookManageService;
import com.Manages.service.impl.BookManageServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class BookManageservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        BookManageService service = new BookManageServiceImpl();
        PrintWriter out = resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        if (flag.equals("list")) {
            List<BookManage> list = null;
            try {
                list = service.getAllBook();
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
                i = service.delBookManage(id);
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
