package com.DAO.DAOImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.DAO.ZhitieDAO;
import com.comm.DButil;

import bean.ZhitieBean;
public class ZhitieDAOImpl implements ZhitieDAO{

	@Override
	public List queryZhitie() throws Exception {
			DButil db = new DButil();
			Connection conn = db.getConnection();
			String sql = "SELECT `zt_id`,`user_id`,`zt_theme`,`zt_title`,`zt_content`,`zt_hfl`,`zt_time`,`user_img` FROM `zt_info`";
			List rslist = new ArrayList();
			System.out.println(sql);
			rslist = db.excutequery(sql, null, conn);
			db.close(conn);
			return rslist;
	}
	@Override
	public List queryMyzt(String user_id) throws Exception {
		DButil db = new DButil();
		Connection conn = db.getConnection();
		String sql = "SELECT `zt_id`,`user_id`,`zt_theme`,`zt_title`,`zt_content`,`zt_hfl`,`zt_time`,`user_img` FROM `zt_info` WHERE `user_id`='"+user_id+"'";
		List rslist = new ArrayList();
  		System.out.println(sql);
		rslist = db.excutequery(sql, null, conn);
		db.close(conn);
		return rslist;
	}
	@Override
	public boolean addZhitie(ZhitieBean zhitie) throws Exception {
		boolean flag = false;
		List list = new ArrayList();
		if(zhitie.getZt_title()!=null && zhitie.getZt_content()!=null &&zhitie.getZt_title()!="" &&zhitie.getZt_content()!="")
		{
			list.add(zhitie.getUser_id());
			list.add(zhitie.getZt_title());
			list.add(zhitie.getZt_content());
			list.add(zhitie.getUser_img());
		}else return false;
		DButil db = new DButil();
		String sql = "INSERT INTO `zt_info`(`user_id`,`zt_title`,`zt_content`,`zt_time`,`user_img`) VALUES(?,?,?,NOW(),?);";
		Connection conn = db.getConnection();
		if(db.excute(sql,list, conn)){
			flag = true;
		}
		db.close(conn);
		return flag;
	}

	@Override
	public void deleteZt(String zt_id) throws Exception{
		DButil db = new DButil();
		Connection conn = db.getConnection();
		String sql = "DELETE FROM `zt_info` WHERE `zt_id`=?;";
		List list = new ArrayList();
		list.add(zt_id);
		db.excute(sql, list, conn);
		db.close(conn);
	}
	@Override
	public List queryZt(String zt_id) throws Exception {
		DButil db = new DButil();
		Connection conn = db.getConnection();
		String sql = "SELECT * FROM `zt_info` WHERE `zt_id`=?;";
		List list = new ArrayList();
		List rslist = new ArrayList();
		list.add(zt_id);
		System.out.println(sql);
		rslist = db.excutequery(sql, list, conn);
		db.close(conn);
		return rslist;
	}
	@Override
	public List queryHfl(String zt_id) throws Exception {
		DButil db = new DButil();
		Connection conn = db.getConnection();
		String sql = "SELECT COUNT(*) FROM `hf_info` WHERE `zt_id`=?;";
		List list = new ArrayList();
		List rslist = new ArrayList();
		list.add(zt_id);
		rslist = db.excutequery(sql, list, conn);
		db.close(conn);
		return rslist;
	}
	@Override
	public void deletePl(String zt_id) throws Exception {
		DButil db = new DButil();
		Connection conn = db.getConnection();
		String sql = "DELETE FROM `hf_info` WHERE `zt_id`=?;";
		List list = new ArrayList();
		list.add(zt_id);
		db.excute(sql, list, conn);
		db.close(conn);
	}
	@Override
	public List queryZt(String condition1, String condition2) throws Exception {
		DButil db = new DButil();
		Connection conn = db.getConnection();
		String sql = "SELECT `zt_id`,`user_id`,`zt_theme`,`zt_title`,`zt_content`,`zt_hfl`,`zt_time`,`user_img` FROM `zt_info`";
		List list = new ArrayList();
		List rslist = new ArrayList();
		
		if(condition1 != null){
			
			if(Integer.parseInt(condition1) != 0){
				switch(Integer.parseInt(condition1)){
				case 1:condition1 = "zt_title";
					break;
				case 2:condition1 = "user_id";
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
	@Override
	public List query(String content) throws Exception {
		DButil db = new DButil();
		Connection conn = db.getConnection();
		String sql = "SELECT `zt_id`,`user_id`,`zt_theme`,`zt_title`,`zt_content`,`zt_hfl`,`zt_time`,`user_img` FROM `zt_info` WHERE user_id LIKE ? OR zt_title LIKE ? OR zt_content LIKE ?;";
		List list = new ArrayList();
		List rslist = new ArrayList();
		list.add("%" + content + "%");
		list.add("%" + content + "%");
		list.add("%" + content + "%");
		System.out.println(sql);
		rslist = db.excutequery(sql, list, conn);
		db.close(conn);
		
		return rslist;
	}

	

}
