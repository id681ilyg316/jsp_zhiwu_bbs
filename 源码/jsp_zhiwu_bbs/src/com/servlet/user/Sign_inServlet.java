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


public class Sign_inServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 登录账号
	 */
	
	String userName;
	String passWord;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------LoginServlet doGet----------------");
		request.getRequestDispatcher("sign_in.jsp").forward(request, response);
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------LoginServlet doPost----------------");
		//获取登录账户
	    HttpSession s = request.getSession(); 
	    String imgFile = "";
	    request.setCharacterEncoding("utf-8");
	    UserBean bean = new UserBean();
	    userName = request.getParameter("userName");
	    bean.setUser_id(request.getParameter("userName"));
	    bean.setUser_password(request.getParameter("passWord"));
		System.out.println(bean.getUser_id()+"  "+bean.getUser_password());
		int flag = 0;
		UserDAO dao = new UserDAOImpl();
		try {
			flag = dao.loginCheck(bean);
			imgFile = dao.getImg(userName);
			
			System.out.println(imgFile);
			System.out.println("输出之前");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//判断是否为管理员
		if(flag == 1){
			//设置session
			System.out.println("登录成功！");
			s.setAttribute("user",userName);
			if(imgFile == null ||imgFile == ""){
				imgFile = "uploadImages/tx2.jpg";
			}
			s.setAttribute("img",imgFile);
			s.setAttribute("dp1","none");
			s.setAttribute("dp2","block");
			System.out.println(imgFile);
			response.sendRedirect("index");
		}else if(flag == 2){
			System.out.println("管理员登录成功！");
			s.setAttribute("user",userName);
			response.sendRedirect("manager");
		}
		else {
			System.out.println("登录失败");
			String message = "请重新确认用户名和密码!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("sign_in.jsp").forward(request, response);
		}
	}

}
