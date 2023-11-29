package com.servlet.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserDAO;
import com.DAO.DAOImpl.UserDAOImpl;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------UserServlet doGet----------------");
		//点击query页面，全查询
		List rslist = new ArrayList();
		UserDAO dao = new UserDAOImpl();
		try {
			rslist = dao.queryUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("rslist", rslist);
		request.getRequestDispatcher("sys/user/query.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------UserServlet doPost----------------");
		//条件查询
		request.setCharacterEncoding("utf-8");
		UserDAO dao = new UserDAOImpl();
		List rslist = new ArrayList();
		//条件1和条件2
		String condition1 = request.getParameter("position");
		String condition2 = request.getParameter("menuname");
		String message = condition2;
		request.setAttribute("message", message);
		System.out.println(condition1 +"  " + condition2);
		try {
			rslist = dao.query(condition1,condition2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("rslist="+rslist);
		request.setAttribute("rslist", rslist);
		request.getRequestDispatcher("sys/user/query.jsp").forward(request, response);
		
		
	}

}
