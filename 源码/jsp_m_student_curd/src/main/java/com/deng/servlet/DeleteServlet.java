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

public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = new Integer(req.getParameter("id"));
		System.out.println(id);
		StuDao stuDao = new StuDaoImp();
		try {
			int index = 0;
			index = stuDao.deleteStu(id);
			if (index > 0) {
				resp.getWriter().write("delete success");
				List<Student> list = stuDao.findTop5();
				req.getSession().setAttribute("list", list);
				resp.sendRedirect("stuinfo.jsp");
			} else {
				System.out.println("delete filed");
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
