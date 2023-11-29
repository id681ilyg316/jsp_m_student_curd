package com.deng.servlet;



import com.deng.dao.StuDao;
import com.deng.dao.imp.StuDaoImp;
import com.deng.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = new Integer(req.getParameter("id"));

        StuDao stuDao = new StuDaoImp();


        try {
            Student student = stuDao.getStu(id);
            req.getSession().setAttribute("student",student);
            System.out.println(student);
            resp.sendRedirect("stuipdate.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
