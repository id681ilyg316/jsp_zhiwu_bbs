package com.DAO;

import java.util.List;

import bean.HfBean;

public interface HfDAO {

	/**
	 * �������۵����ݿ�
	 * @param hf
	 * @return
	 */
	boolean insertHf(HfBean hf) throws Exception;

	/**
	 * ��������id���һظ�
	 * @param zt_id 
	 * @return
	 * @throws Exception
	 */
	public List queryHf(String zt_id) throws Exception;

	/**
	 * ���ݻظ�idɾ���ظ�
	 * @param hf_id
	 * @throws Exception
	 */
	public void deleteHf(String hf_id) throws Exception;

	/**
	 * �����û�id���һظ�
	 * @param user_id
	 * @return
	 */
	public List queryMyHf(String user_id) throws Exception;

	/**
	 * ����ֲ��������
	 * @param string
	 * @param flag 
	 * @throws Exception
	 */
	public boolean changeHf(String zt_id, boolean flag) throws Exception;

	/**
	 * ��ѯ���лظ�
	 * @return
	 * @throws Exception
	 */
	public List queryAllHf() throws Exception;

	/**
	 * ������ѯ�ظ�����
	 * @param condition1
	 * @param condition2
	 * @return
	 */
	public List queryHf(String condition1, String condition2) throws Exception;

}
