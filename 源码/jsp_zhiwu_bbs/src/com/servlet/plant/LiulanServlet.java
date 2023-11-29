package com.servlet.plant;

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


public class LiulanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------LiulanServlet doGet----------------");
		
		List rslist = new ArrayList();
		ZhitieDAO dao = new ZhitieDAOImpl();
		//根据字段查找植帖
		String content = request.getParameter("content");
		String user_id = request.getParameter("user_id");
		if(content != null && content !=""){
			try {
				System.out.println("content内容"+content);
				rslist = dao.query(content);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(rslist.size()<1){
				String msg = "查无关于\""+content+"\"的内容";
				request.setAttribute("msg", msg);
			}
			request.setAttribute("rslist", rslist);
			request.getRequestDispatcher("zhitie.jsp").forward(request, response);
		}
		//根据用户名查找植帖
		else if(user_id != null && user_id != ""){
			try {
				System.out.println("user_id内容"+user_id);
				rslist = dao.queryMyzt(user_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("rslist", rslist);
			request.getRequestDispatcher("zhitie.jsp").forward(request, response);
		}else{
			//点击query页面，全查询
			try {
				rslist = dao.queryZhitie();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//使最新发布的植帖总是在最前端
			Collections.reverse(rslist); 
			request.setAttribute("rslist", rslist);
			request.getRequestDispatcher("zhitie.jsp").forward(request, response);
		}
	}
}
