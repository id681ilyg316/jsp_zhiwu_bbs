package com.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.DAO.DAOImpl.UserDAOImpl;

import bean.UserBean;


public class Sign_upServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------sign_upServlet doGet----------------");
		request.getRequestDispatcher("sign_up.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------Sign_upServlet doPost----------------");
		//ͳһsql����
		request.setCharacterEncoding("utf-8");
		UserBean bean = new UserBean();
		bean.setUser_id(request.getParameter("userId"));
		bean.setUser_password(request.getParameter("userPass2"));
		//Ĭ��ͷ��
		bean.setUser_img("uploadImages/tx2.jpg");
		//�����û�
		
		UserDAO dao = new UserDAOImpl();
		boolean flag = false;
		if(request.getParameter("userPass1").equals(request.getParameter("userPass2"))){
		
		try {
			flag = dao.addUser(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(flag){
			System.out.println("ע��ɹ���");
			String msg = "ע��ɹ��������µ�¼��";
			request.setAttribute("msg",msg);
			request.getRequestDispatcher("sign_up.jsp").forward(request, response);		
		}else {
			System.out.println("ע��ʧ�ܣ�");
			String msg = "ע��ʧ��,�û��Ѵ��ڻ����벻��֤ʧ�ܣ�";
			request.setAttribute("msg",msg);
			request.getRequestDispatcher("sign_up.jsp").forward(request, response);
		}
	}

}
