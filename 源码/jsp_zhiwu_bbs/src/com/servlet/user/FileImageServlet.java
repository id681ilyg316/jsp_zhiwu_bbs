package com.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserDAO;
import com.DAO.DAOImpl.UserDAOImpl;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;

import bean.UserBean;


public class FileImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------fileimageServlet doGet----------------");
		request.getRequestDispatcher("self.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------fileimageServlet doPost----------------");
		request.setCharacterEncoding("utf-8");
		String filepath = "";
		try{
			SmartUpload upload = new SmartUpload();
			upload.setAllowedFilesList("jpg,bmp,icon,png");//设置图片上传格式
			upload.initialize(this.getServletConfig(), request, response);
			upload.upload();
			Files f = upload.getFiles();
			File fil = f.getFile(0);
			String ext = fil.getFileExt();
			fil.saveAs("uploadImages/" + fil.getFileName());
			filepath = "uploadImages/" + fil.getFileName();
			System.out.println(filepath);
			
		}catch(Exception ex){
            ex.printStackTrace();
        }
		//用户bean
		UserBean bean = new UserBean();
		bean.setUser_id((String)request.getSession().getAttribute("user"));
		bean.setUser_img(filepath);
		
		UserDAO dao = new UserDAOImpl();
		boolean flag = false;
		
		try {
			flag = dao.changeUserImage(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(flag){
			System.out.println("上传成功！");
			String msg2 = "上传成功！";
			request.getSession().setAttribute("img", bean.getUser_img());
			request.setAttribute("msg2",msg2);
			request.getRequestDispatcher("self.jsp").forward(request, response);		
		}else {
			System.out.println("上传失败！");
			String msg2 = "上传失败！(可用格式jpg,bmp,icon,png)";
			request.setAttribute("msg2",msg2);
			request.getRequestDispatcher("self.jsp").forward(request, response);
		}
	}

}
