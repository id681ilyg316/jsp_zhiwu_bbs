package com.servlet.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.HfDAO;
import com.DAO.DAOImpl.HfDAOImpl;


public class QueryPlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------QueryPlServlet doGet----------------");
		//点击query页面，全查询
		List rslist = new ArrayList();
		HfDAO dao = new HfDAOImpl();
		try {
			rslist = dao.queryAllHf();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("rslist", rslist);
		request.getRequestDispatcher("sys/pl/queryPl.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------QueryPlServlet doPost----------------");
		//条件查询评论
		request.setCharacterEncoding("utf-8");
		HfDAO dao = new HfDAOImpl();
		List rslist = new ArrayList();
		//条件1和条件2
		String condition1 = request.getParameter("position");
		String condition2 = request.getParameter("menuname");
		String message = condition2;
		request.setAttribute("message", message);
		System.out.println(condition1 +"  " + condition2);
		try {
			rslist = dao.queryHf(condition1,condition2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("rslist="+rslist);
		request.setAttribute("rslist", rslist);
		request.getRequestDispatcher("sys/pl/queryPl.jsp").forward(request, response);
		
	}

}
