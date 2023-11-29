package com.servlet.message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.HfDAO;
import com.DAO.DAOImpl.HfDAOImpl;


public class MyHfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------MyHfServlet doGet----------------");
		//点击query页面，全查询
		List rslist = new ArrayList();
		HfDAO dao = new HfDAOImpl();
		String user_id = (String)request.getSession().getAttribute("user");
		try {
			rslist = dao.queryMyHf(user_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将最新回复放到最前
		Collections.reverse(rslist);
		request.setAttribute("hflist", rslist);
		request.getRequestDispatcher("myhf.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
