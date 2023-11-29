package com.DAO.DAOImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.DAO.UserDAO;
import com.comm.DButil;


import bean.UserBean;

public class UserDAOImpl implements UserDAO {

	@Override
	public int loginCheck(UserBean bean) throws Exception {
		int flag = 0;
		
		DButil db = new DButil();
		String sql = "SELECT `user_level` FROM `user_info` WHERE `user_id`=? AND `user_password`=?";
		Connection conn = db.getConnection();
		
		List<Object> list = new ArrayList<Object>();
		list.add(bean.getUser_id());
		list.add(bean.getUser_password());
		
		List rs = db.excutequery(sql, list, conn);

		//是管理员返回2，不是返回1
		System.out.println(rs.get(0).toString());
		if(rs.size() == 1){
			if(rs.get(0).toString().equals("{user_level=1}")){
				flag = 2;
			}else flag = 1;
		}
		//关闭链接
		db.close(conn);
		return flag;
	}

	@Override
	public boolean addUser(UserBean bean) throws Exception {
		boolean flag = false;
		List list = new ArrayList();
		DButil db = new DButil();
		String sql = "INSERT INTO `user_info`(`user_id`,`user_password`,`user_regdate`,`user_modificationtime`,user_img) VALUES(?,?,NOW(),NOW(),?);";
		//检查用户名密码不为空
		if(bean.getUser_id()=="" || bean.getUser_password()==""){
			return false;
		}
		list.add(bean.getUser_id());
		list.add(bean.getUser_password());
		list.add(bean.getUser_img());
		
		Connection conn = db.getConnection();
		if(db.excute(sql,list, conn)){
			flag = true;
		}
		db.close(conn);
		return flag;
		
	}
	@Override
	public boolean changeUser(UserBean bean) throws Exception {
		boolean flag = false;
		List list = new ArrayList();
		DButil db = new DButil();
		String sql = " UPDATE `user_info` SET `user_password`=?, `user_nickname`=?, `user_modificationtime`=NOW(),`user_sex`=? WHERE `user_id`=?;";
		if(bean.getUser_id()=="" || bean.getUser_password()==""){
			return false;
		}
		
		list.add(bean.getUser_password());
		list.add(bean.getUser_nickname());
		list.add(bean.getUser_sex());
		list.add(bean.getUser_id());

		
		Connection conn = db.getConnection();
		if(db.excute(sql,list, conn)){
			flag = true;
		}
		db.close(conn);
		return flag;
	}
	@Override
	public List queryUser() throws Exception{
		
		DButil db = new DButil();
		Connection conn = db.getConnection();
		String sql = "SELECT `user_id`,`user_password`,`user_nickname`,`user_sex`,`user_regdate`,`user_modificationtime`,user_img FROM `user_info`";
		List rslist = new ArrayList();
		
		
		System.out.println(sql);
		rslist = db.excutequery(sql, null, conn);
		db.close(conn);
		
		return rslist;

	}
	@Override
	public void deleteUser(String user_id) throws Exception {
		DButil db = new DButil();
		Connection conn = db.getConnection();
		String sql = "DELETE FROM `user_info` WHERE `user_id`=?";
		List list = new ArrayList();
		list.add(user_id);
		db.excute(sql, list, conn);
		db.close(conn);
	}

	@Override
	public boolean changeUserImage(UserBean bean) throws Exception {
		boolean flag = false;
		List list = new ArrayList();
		DButil db = new DButil();
		String sql = " UPDATE `user_info` SET `user_modificationtime`=NOW(),`user_img`=? WHERE `user_id`=?;";
		if(bean.getUser_img()==null || bean.getUser_img()== "")
		{
			return false;
		}
		list.add(bean.getUser_img());
		list.add(bean.getUser_id());
		Connection conn = db.getConnection();
		if(db.excute(sql,list, conn)){
			flag = true;
		}
		db.close(conn);
		return flag;
	}

	@Override
	public String getImg(String userName) throws Exception {
		String imgFile = "";
		DButil db = new DButil();
		String sql = "SELECT `user_img` FROM `user_info` WHERE `user_id`=?;";
		List rslist = new ArrayList();
		Connection conn = db.getConnection();
		List list = new ArrayList();
		list.add(userName);
		System.out.println(sql);
		imgFile = db.queryImg(sql, list, conn);
		db.close(conn);
		return imgFile;
	}

	@Override
	public List query(String condition1, String condition2) throws Exception {
		DButil db = new DButil();
		Connection conn = db.getConnection();
		String sql = "SELECT `user_id`,`user_password`,`user_nickname`,`user_sex`,`user_regdate`,`user_modificationtime`,user_img FROM `user_info`";
		List list = new ArrayList();
		List rslist = new ArrayList();
		
		if(condition1 != null){
			
			if(Integer.parseInt(condition1) != 0){
				switch(Integer.parseInt(condition1)){
				case 1:condition1 = "user_id";
					break;
				}
				sql = sql + " where " +condition1+" like ?";
				
				list.add("%" + condition2 + "%");
			}
		}
		System.out.println(sql);
		rslist = db.excutequery(sql, list, conn);
		db.close(conn);
		
		return rslist;
	}

	
	
}
