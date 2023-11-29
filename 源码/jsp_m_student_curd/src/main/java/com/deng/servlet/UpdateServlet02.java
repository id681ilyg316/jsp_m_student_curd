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

public class UpdateServlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = new Integer(req.getParameter("id"));
        String name = req.getParameter("name");
        Integer age = new Integer(req.getParameter("age"));
        String addr = req.getParameter("addr");
        String gender = req.getParameter("gender");

        Student student = new Student(id,name,age,addr,gender);
        System.out.println(student);

        StuDao stuDao = new StuDaoImp();


        try {
            int index = stuDao.updateStu(student);
            if (index>0){
                resp.getWriter().write("update successary");
                List<Student> list = stuDao.findAll();
                req.getSession().setAttribute("list", list);
                resp.sendRedirect("stuinfo.jsp");
            }else {
                resp.getWriter().write("update failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
