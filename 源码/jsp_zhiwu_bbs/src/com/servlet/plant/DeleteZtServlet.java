package com.servlet.plant;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ZhitieDAO;
import com.DAO.DAOImpl.ZhitieDAOImpl;


public class DeleteZtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------DeleteZt doGet----------------");
		String zt_id = request.getParameter("zt_id");
		System.out.println(zt_id);
		ZhitieDAO dao = new ZhitieDAOImpl();
		try {
			dao.deleteZt(zt_id);
			dao.deletePl(zt_id);
		} catch (Exception e) {

			e.printStackTrace();
		}
		 response.sendRedirect("myzt"); 
	}

}
