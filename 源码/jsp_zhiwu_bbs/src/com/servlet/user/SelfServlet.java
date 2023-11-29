package com.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.DAO.UserDAO;
import com.DAO.DAOImpl.UserDAOImpl;

import bean.UserBean;


public class SelfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------selfChangeServlet doGet----------------");
		request.getRequestDispatcher("self.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------selfChangeServlet doPost----------------");
		//ͳһsql����
		request.setCharacterEncoding("utf-8");
		UserDAO dao = new UserDAOImpl();
		UserBean bean = new UserBean();
		bean.setUser_password(request.getParameter("oldUserPass"));
		bean.setUser_id((String)request.getSession().getAttribute("user"));
		try {
			int check = dao.loginCheck(bean);
			if(check>=1){
				bean.setUser_password(request.getParameter("userPass2"));
				bean.setUser_sex(Integer.parseInt(request.getParameter("sex")));
			}else{
				System.out.println("�޸�ʧ�ܣ�ԭʼ���벻��ȷ��");
				String msg1 = "�޸�ʧ�ܣ�ԭʼ���벻��ȷ��";
				request.setAttribute("msg1",msg1);
				request.getRequestDispatcher("self.jsp").forward(request, response);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//�޸��û�
		boolean flag = false;
		if(request.getParameter("userPass1").equals(request.getParameter("userPass2")))
		{
			try {
				flag = dao.changeUser(bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(flag){
				System.out.println("�޸ĳɹ���");
				String msg1 = "�޸ĳɹ���";
				request.setAttribute("msg1",msg1);
				request.getRequestDispatcher("self.jsp").forward(request, response);		
			}else {
				System.out.println("�޸�ʧ�ܣ��������벻ƥ�䣡");
				String msg1 = "�޸�ʧ�ܣ��������벻ƥ�䣡";
				request.setAttribute("msg1",msg1);
				request.getRequestDispatcher("self.jsp").forward(request, response);
		}
	}

}
