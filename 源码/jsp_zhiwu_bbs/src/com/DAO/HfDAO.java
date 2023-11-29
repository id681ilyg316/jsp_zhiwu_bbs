package com.DAO;

import java.util.List;

import bean.HfBean;

public interface HfDAO {

	/**
	 * 插入评论到数据库
	 * @param hf
	 * @return
	 */
	boolean insertHf(HfBean hf) throws Exception;

	/**
	 * 根据帖子id查找回复
	 * @param zt_id 
	 * @return
	 * @throws Exception
	 */
	public List queryHf(String zt_id) throws Exception;

	/**
	 * 根据回复id删除回复
	 * @param hf_id
	 * @throws Exception
	 */
	public void deleteHf(String hf_id) throws Exception;

	/**
	 * 根据用户id查找回复
	 * @param user_id
	 * @return
	 */
	public List queryMyHf(String user_id) throws Exception;

	/**
	 * 更新植帖评论数
	 * @param string
	 * @param flag 
	 * @throws Exception
	 */
	public boolean changeHf(String zt_id, boolean flag) throws Exception;

	/**
	 * 查询所有回复
	 * @return
	 * @throws Exception
	 */
	public List queryAllHf() throws Exception;

	/**
	 * 条件查询回复内容
	 * @param condition1
	 * @param condition2
	 * @return
	 */
	public List queryHf(String condition1, String condition2) throws Exception;

}
