package com.DAO;

import java.util.List;

import bean.UserBean;

public interface UserDAO {

	/**
	 * ��¼��⣬�鿴���ݿ��Ƿ��и��û�,��û���򷵻�0���в���Ϊ�ǹ���Ա����1������Ա����2
	 * @param userName
	 * @param passWord
	 * @return
	 * @throws Exception
	 */
	public int loginCheck(UserBean bean) throws Exception;

	/**
	 * ����û������û�ע����Ϣ�������ݿ�
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean addUser(UserBean bean) throws Exception;

	/**
	 * ������ѯ
	 * @param condition1
	 * @param condition2
	 * @return
	 * @throws Exception
	 */
	public List queryUser() throws Exception;
	
	/**
	 * ɾ���û�
	 * @param user_id
	 * @throws Exception
	 */
	public void deleteUser(String user_id) throws Exception;

	/**
	 * �޸��û��ķ���
	 * @param bean
	 * @return
	 */
	public boolean changeUser(UserBean bean) throws Exception;

	/**
	 * �޸��û�ͷ��
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean changeUserImage(UserBean bean) throws Exception;

	/**
	 * ��ȡ�û�ͷ�񴢴�·��
	 * @param userName
	 * @return
	 */
	public String getImg(String userName) throws Exception;

	/**
	 * ������ѯ���
	 * @param condition1
	 * @param condition2
	 * @return
	 */
	public List query(String condition1, String condition2) throws Exception;
	
}
