package com.servlet.message;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.HfDAO;
import com.DAO.DAOImpl.HfDAOImpl;


public class DeleteHfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	//É¾³ý»Ø¸´¹¦ÄÜ
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------DeleteHfServlet doGet----------------");
		String hf_id = request.getParameter("hf_id");
		String zt_id = request.getParameter("zt_id");
		System.out.println(hf_id);
		HfDAO dao = new HfDAOImpl();
		try {
			dao.deleteHf(hf_id);
			dao.changeHf(zt_id, false);
		} catch (Exception e) {

			e.printStackTrace();
		}
		response.sendRedirect("myhf"); 
	}
}
