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

public class StuInsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name = req.getParameter("name");
        String strage = req.getParameter("age");
        Integer age = new Integer(strage);
        String addr = req.getParameter("addr");
        String gender = req.getParameter("gender");

        System.out.println(name);
        System.out.println(strage);
        System.out.println(age);
        System.out.println(addr);
        System.out.println(gender);

        Student student = new Student(name,age,addr,gender);
        System.out.println(student);

        StuDao stuDao = new StuDaoImp();
        try {
            stuDao.insertStu(student);
            System.out.println("添加完毕");
            List<Student> list = stuDao.findAll();
            req.getSession().setAttribute("list", list);
            resp.sendRedirect("stuinfo.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
