package com.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserDAO;
import com.DAO.DAOImpl.UserDAOImpl;


public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------deleteServlet doGet----------------");
		String user_id = request.getParameter("user_id");
		System.out.println(user_id);
		UserDAO dao = new UserDAOImpl();
		try {
			dao.deleteUser(user_id);
		} catch (Exception e) {

			e.printStackTrace();
		}
		 response.sendRedirect("manage"); 
	}

}
