package com.servlet.plant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ZhitieDAO;
import com.DAO.DAOImpl.ZhitieDAOImpl;


public class MyztServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------MyztServlet doGet----------------");
		//点击query页面，全查询
		List rslist = new ArrayList();
		ZhitieDAO dao = new ZhitieDAOImpl();
		String user_id = (String)request.getSession().getAttribute("user");
		try {
			rslist = dao.queryMyzt(user_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("rslist", rslist);
		request.getRequestDispatcher("myzt.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------MyztServlet doPost----------------");
	}

}
