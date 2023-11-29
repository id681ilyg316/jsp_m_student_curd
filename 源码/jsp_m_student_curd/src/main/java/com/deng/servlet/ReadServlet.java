package com.deng.servlet;



import com.deng.dao.StuDao;
import com.deng.dao.imp.StuDaoImp;
import com.deng.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String selectname = req.getParameter("selectname");
        System.out.println(selectname);
        StuDao stuDao = new StuDaoImp();
        try {
            List<Student> list = stuDao.readStu(selectname);
            System.out.println("list");
            req.getSession().setAttribute("list",list);
            resp.sendRedirect("stuinfo.jsp");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
