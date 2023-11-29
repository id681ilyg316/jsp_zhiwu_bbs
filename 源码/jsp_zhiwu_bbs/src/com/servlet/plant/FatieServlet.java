package com.servlet.plant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ZhitieDAO;
import com.DAO.DAOImpl.ZhitieDAOImpl;

import bean.ZhitieBean;


public class FatieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------FaTieServlet doGet----------------");
		request.getRequestDispatcher("fatie.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------FaTieServlet doPost----------------");
		request.setCharacterEncoding("utf-8");
		ZhitieBean zhitie = new ZhitieBean();
		zhitie.setUser_id((String)request.getSession().getAttribute("user"));
		zhitie.setUser_img((String)request.getSession().getAttribute("img"));
		zhitie.setZt_content(request.getParameter("ztContent"));
		zhitie.setZt_title(request.getParameter("ztTitle"));
		
		ZhitieDAO dao = new ZhitieDAOImpl();
		boolean flag = false;
		try {
			flag = dao.addZhitie(zhitie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag){
			System.out.println("发帖成功！");
			response.sendRedirect("zhitie");	
		}else {
			System.out.println("发帖失败！");
			String msg = "发帖失败！请输入正确的标题和内容！";
			request.setAttribute("msg",msg);
			request.getRequestDispatcher("fatie.jsp").forward(request, response);
		}
	}

}
