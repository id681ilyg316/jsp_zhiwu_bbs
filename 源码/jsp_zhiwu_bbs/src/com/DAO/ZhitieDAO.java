package com.DAO;

import java.util.List;

import bean.ZhitieBean;

public interface ZhitieDAO {

	/**
	 * 查询已发布的所有植帖
	 * @return
	 * @throws Exception
	 */
	public List queryZhitie() throws Exception;

	/**
	 * 发布植帖
	 * @param zhitie
	 * @return
	 * @throws Exception
	 */
	public boolean addZhitie(ZhitieBean zhitie) throws Exception;

	/**
	 * 删除植帖
	 * @param zt_id
	 */
	public void deleteZt(String zt_id) throws Exception;

	/**
	 * 查询用户植帖
	 * @param user_id
	 * @return
	 */
	public List queryMyzt(String user_id) throws Exception;

	/**
	 * 根据植帖id查询植帖
	 * @param zt_id
	 * @throws Exception
	 */
	public List queryZt(String zt_id) throws Exception;

	/**
	 * 查询植帖回复数
	 * @param zt_id
	 * @return
	 */
	public List queryHfl(String zt_id) throws Exception;

	/**
	 * 删除植帖的同时删除评论
	 * @param zt_id
	 */
	public void deletePl(String zt_id) throws Exception;

	/**
	 * 根据前台传回的数据查询植帖
	 * @param condition1
	 * @param condition2
	 * @return
	 */
	public List queryZt(String condition1, String condition2) throws Exception;

	/**
	 * 查询所有和content相关的植帖
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public List query(String content) throws Exception;
 
}
