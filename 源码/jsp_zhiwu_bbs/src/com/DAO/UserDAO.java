package com.DAO;

import java.util.List;

import bean.UserBean;

public interface UserDAO {

	/**
	 * 登录检测，查看数据库是否有该用户,如没有则返回0，有并且为非管理员返回1，管理员返回2
	 * @param userName
	 * @param passWord
	 * @return
	 * @throws Exception
	 */
	public int loginCheck(UserBean bean) throws Exception;

	/**
	 * 添加用户，将用户注册信息加入数据库
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean addUser(UserBean bean) throws Exception;

	/**
	 * 条件查询
	 * @param condition1
	 * @param condition2
	 * @return
	 * @throws Exception
	 */
	public List queryUser() throws Exception;
	
	/**
	 * 删除用户
	 * @param user_id
	 * @throws Exception
	 */
	public void deleteUser(String user_id) throws Exception;

	/**
	 * 修改用户的方法
	 * @param bean
	 * @return
	 */
	public boolean changeUser(UserBean bean) throws Exception;

	/**
	 * 修改用户头像
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean changeUserImage(UserBean bean) throws Exception;

	/**
	 * 获取用户头像储存路径
	 * @param userName
	 * @return
	 */
	public String getImg(String userName) throws Exception;

	/**
	 * 条件查询语句
	 * @param condition1
	 * @param condition2
	 * @return
	 */
	public List query(String condition1, String condition2) throws Exception;
	
}
