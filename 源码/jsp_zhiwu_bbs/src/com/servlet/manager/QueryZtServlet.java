package com.servlet.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ZhitieDAO;
import com.DAO.DAOImpl.ZhitieDAOImpl;


public class QueryZtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------QueryZtServlet doGet----------------");
		List rslist = new ArrayList();
		ZhitieDAO dao = new ZhitieDAOImpl();
		//�����û�������ֲ��
		String user_id = request.getParameter("user_id");
		if(user_id != null && user_id != ""){
			try {
				rslist = dao.queryMyzt(user_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("rslist", rslist);
			request.getRequestDispatcher("sys/zt/queryZt.jsp").forward(request, response);
		}
		//���queryҳ�棬ȫ��ѯ
		else{
			try {
				rslist = dao.queryZhitie();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("rslist", rslist);
			request.getRequestDispatcher("sys/zt/queryZt.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------QueryZtServlet doPost----------------");
		//������ѯֲ��
		request.setCharacterEncoding("utf-8");
		ZhitieDAO dao = new ZhitieDAOImpl();
		List rslist = new ArrayList();
		//����1������2
		String condition1 = request.getParameter("position");
		String condition2 = request.getParameter("menuname");
		String message = condition2;
		request.setAttribute("message", message);
		System.out.println(condition1 +"  " + condition2);
		try {
			rslist = dao.queryZt(condition1,condition2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��������list
		Collections.reverse(rslist);
		System.out.println("rslist="+rslist);
		request.setAttribute("rslist", rslist);
		request.getRequestDispatcher("sys/zt/queryZt.jsp").forward(request, response);
		
	}

}
