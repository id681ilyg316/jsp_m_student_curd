package com.deng.servlet;


import com.deng.dao.StuDao;
import com.deng.dao.UserDao;
import com.deng.dao.imp.StuDaoImp;
import com.deng.dao.imp.UserDaoImp;
import com.deng.pojo.PageBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static com.deng.dao.StuDao.PAG_SIZE;


public class LoginServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //提交的数据有可能有中文， 怎么处理。
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        //1. 获取客户端提交的信息
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        //2. 去访问dao ， 看看是否满足登录。
        UserDao dao = new UserDaoImp();
        boolean isSuccess = dao.login(userName, password);

        //3. 针对dao的返回结果，做出响应
        if(isSuccess){
            //1. 查询出来所有的学生信息。
            StuDao stuDao = new StuDaoImp();
            PageBean pageBean = new PageBean();
            try {
                pageBean.setList(stuDao.findStudentByPage(1));
                pageBean.setCurrentPage(1);
                pageBean.setPageSize(PAG_SIZE);
                pageBean.setTotalSize(stuDao.findStuCount());
                pageBean.setTotalPage(stuDao.findStuCount()%PAG_SIZE==0?stuDao.findStuCount()/PAG_SIZE : (stuDao.findStuCount()/PAG_SIZE)+1);
                System.out.println(pageBean);
                request.getSession().setAttribute("list",pageBean.getList());
                request.getSession().setAttribute("pageBean",pageBean);
                //请求重定向
                response.sendRedirect("stuinfo.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }else{
            response.getWriter().write("用户名或者密码错误！");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
