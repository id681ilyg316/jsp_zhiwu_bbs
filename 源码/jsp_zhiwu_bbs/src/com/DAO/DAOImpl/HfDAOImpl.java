package com.DAO.DAOImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.DAO.HfDAO;
import com.comm.DButil;

import bean.HfBean;

public class HfDAOImpl implements HfDAO {

	@Override
	public boolean insertHf(HfBean hf) throws Exception {
		boolean flag = false;
		List list = new ArrayList();
		DButil db = new DButil();
		String sql = "INSERT INTO `hf_info`(`user_id`,`zt_id`,`hf_content`,`hf_time`,user_img) VALUES(?,?,?,NOW(),?);";
		list.add(hf.getUser_id());
		list.add(hf.getZt_id());
		list.add(hf.getHf_content());
		list.add(hf.getUser_img());
		Connection conn = db.getConnection();
		if(db.excute(sql,list, conn)){
			flag = true;
		}
		db.close(conn);
		return flag;
	}

	@Override
	public List queryHf(String zt_id) throws Exception {
		DButil db = new DButil();
		Connection conn = db.getConnection();
		//根据植帖id查找评论
		String sql = "SELECT `user_id`,`hf_content`,`hf_time`,`user_img` FROM `hf_info` WHERE `zt_id`=?;";
		List rslist = new ArrayList();
		List list = new ArrayList();
		list.add(zt_id);
		System.out.println(sql);
		rslist = db.excutequery(sql, list, conn);
		db.close(conn);
		return rslist;
	}

	@Override
	public void deleteHf(String hf_id) throws Exception {
		DButil db = new DButil();
		Connection conn = db.getConnection();
		String sql = "DELETE FROM `hf_info` WHERE `hf_id`=?";
		List list = new ArrayList();
		list.add(hf_id);
		db.excute(sql, list, conn);
		db.close(conn);
	}

	@Override
	public List queryMyHf(String user_id) throws Exception {
		DButil db = new DButil();
		Connection conn = db.getConnection();
		String sql = "SELECT hf_info.`hf_id`,hf_info.`zt_id`,hf_info.`hf_content`, hf_info.`hf_time`, zt_info.`zt_title` FROM `hf_info`,`zt_info` WHERE hf_info.`zt_id`=zt_info.`zt_id` AND hf_info.`user_id`=?;";
		List rslist = new ArrayList();
		List list = new ArrayList();
		list.add(user_id);
		System.out.println(sql);
		rslist = db.excutequery(sql, list, conn);
		db.close(conn);
		return rslist;
	}

	@Override
	public boolean changeHf(String zt_id,boolean flag) throws Exception {
		DButil db = new DButil();
		boolean flag_change = false;
		Connection conn = db.getConnection();
		String sql = "";
		if(flag){
			sql = " UPDATE `zt_info` SET `zt_hfl`=`zt_hfl`+ 1 WHERE `zt_id`=?;";
		}else{
			sql = " UPDATE `zt_info` SET `zt_hfl`=`zt_hfl`- 1 WHERE `zt_id`=?;";
		}
		List rslist = new ArrayList();
		List list = new ArrayList();
		list.add(zt_id);
		if(db.excute(sql,list, conn)){
			flag_change = true;
		}
		db.close(conn);
		return flag_change;
	}

	@Override
	public List queryAllHf() throws Exception {
		DButil db = new DButil();
		Connection conn = db.getConnection();
		//根据植帖id查找评论
		String sql = "SELECT hf_info.`user_id`,hf_info.`user_img`,hf_info.`hf_id`,hf_info.`zt_id`,hf_info.`hf_content`, hf_info.`hf_time`, zt_info.`zt_title` FROM `hf_info`,`zt_info` WHERE hf_info.`zt_id`=zt_info.`zt_id` ";
		List rslist = new ArrayList();
		System.out.println(sql);
		rslist = db.excutequery(sql, null, conn);
		db.close(conn);
		return rslist;
	}

	@Override
	public List queryHf(String condition1, String condition2) throws Exception {
		DButil db = new DButil();
		Connection conn = db.getConnection();
		String sql = "SELECT hf_info.`user_id`,hf_info.`user_img`,hf_info.`hf_id`,hf_info.`zt_id`,hf_info.`hf_content`, hf_info.`hf_time`, zt_info.`zt_title` FROM `hf_info`,`zt_info`";
		List list = new ArrayList();
		List rslist = new ArrayList();
		
		if(condition1 != null){
			
			if(Integer.parseInt(condition1) != 0){
				switch(Integer.parseInt(condition1)){
				case 1:condition1 = "hf_info.user_id";
					break;
				case 2:condition1 = "hf_info.hf_content";
					break;
				case 3:condition1 = "zt_info.zt_title";
					break;
				}
				sql = sql + " where " +condition1+" like ?" + "AND hf_info.`zt_id`=zt_info.`zt_id`";
				
				list.add("%" + condition2 + "%");
			}
		}
		System.out.println(sql);
		rslist = db.excutequery(sql, list, conn);
		db.close(conn);
		
		return rslist;
	}

}
