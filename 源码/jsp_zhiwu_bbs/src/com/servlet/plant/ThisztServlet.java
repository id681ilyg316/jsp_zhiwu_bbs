package com.servlet.plant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.HfDAO;
import com.DAO.ZhitieDAO;
import com.DAO.DAOImpl.HfDAOImpl;
import com.DAO.DAOImpl.ZhitieDAOImpl;

import bean.HfBean;
import bean.ZhitieBean;

public class ThisztServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------ThisztServlet doGet----------------");
		String zt_id = request.getParameter("zt_id");
		ZhitieBean zhitiebean = new ZhitieBean();
		zhitiebean.setZt_id(Integer.parseInt(zt_id));
		System.out.println(zt_id);
		ZhitieDAO dao = new ZhitieDAOImpl();
		List list = new ArrayList();
		try {
			list = dao.queryZt(zt_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//得到植帖bean
		Map map = new HashMap();
		map = (Map)list.get(0);
		Set<String> get = map.keySet(); 
	    for (String info:get) {
	    	switch(info){
		   	 	case "zt_id":zhitiebean.setZt_id(Integer.parseInt(zt_id));break;
		    	case "user_id":zhitiebean.setUser_id(map.get(info).toString());break;
		    	case "zt_theme":zhitiebean.setZt_theme(map.get(info).toString());break;
		    	case "zt_title":zhitiebean.setZt_title(map.get(info).toString());break;
		    	case "zt_content":zhitiebean.setZt_content(map.get(info).toString());break;
		    	case "zt_time":zhitiebean.setZt_time(map.get(info).toString());break;
		    	case "user_img":zhitiebean.setUser_img(map.get(info).toString());break;
		    	case "zt_hfl":zhitiebean.setZt_hfl(Integer.parseInt(map.get(info).toString()));break;
	    	}
	    	System.out.println(info+","+map.get(info));
	    }
	    //查找该植帖评论
	    List hflist = new ArrayList();
	    HfDAO hfdao = new HfDAOImpl();
	    try {
			hflist = hfdao.queryHf(zt_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //将植帖bean和评论list传给jsp
	    for(int i = 0;i < hflist.size();i++){
	    	System.out.println(""+hflist.get(i));
	    }
	    
	    request.setAttribute("zhitiebean", zhitiebean);
	    request.setAttribute("title", zhitiebean.getZt_title());
	    request.setAttribute("hflist", hflist);
	    request.getRequestDispatcher("thiszt.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------ThisztServlet doPost----------------");
		//评论功能
		if(request.getSession().getAttribute("user")==null||request.getSession().getAttribute("user")==""){
			String message = "请登录后再进行评论!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("sign_in.jsp").forward(request, response);
			
		}
		request.setCharacterEncoding("utf-8");
		HfBean hf = new HfBean();
		hf.setHf_content(request.getParameter("hfContent"));
		hf.setZt_id(request.getParameter("zt_id"));
		hf.setUser_id((String)request.getSession().getAttribute("user"));
		hf.setUser_img((String)request.getSession().getAttribute("img"));
		HfDAO dao = new HfDAOImpl();
		boolean flag = false;
		boolean flag_change = false;
		try{
			if(hf.getHf_content().toString() != "" && hf.getHf_content().toString()!= null){
				flag = dao.insertHf(hf);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(flag){
			System.out.println("评论成功！");
			//评论成功植帖评论数变化
			try {
				flag_change = dao.changeHf(hf.getZt_id(),flag);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag_change){
				System.out.println("评论数增加成功！");
			}else{
				System.out.println("评论数增加失败！");
			}
			response.sendRedirect("this?zt_id="+request.getParameter("zt_id"));
		}else{
			System.out.println("评论失败！");
			response.sendRedirect("this?zt_id="+request.getParameter("zt_id"));
		}
		
		
	}

}
