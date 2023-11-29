package com.deng.servlet;


import com.deng.dao.StuDao;
import com.deng.dao.imp.StuDaoImp;
import com.deng.pojo.PageBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static com.deng.dao.StuDao.PAG_SIZE;


public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage= Integer.parseInt(req.getParameter("currentPage"));
        StuDao stuDao = new StuDaoImp();
        PageBean pageBean = new PageBean();

        try {
            pageBean.setList(stuDao.findStudentByPage(currentPage));
            pageBean.setCurrentPage(currentPage);
            pageBean.setPageSize(PAG_SIZE);
            pageBean.setTotalSize(stuDao.findStuCount());
            pageBean.setTotalPage(stuDao.findStuCount()%PAG_SIZE==0?stuDao.findStuCount()/PAG_SIZE : (stuDao.findStuCount()/PAG_SIZE)+1);
            System.out.println(pageBean);

            req.getSession().setAttribute("list",pageBean.getList());
            req.getSession().setAttribute("pageBean",pageBean);
            resp.sendRedirect("stuinfo.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
