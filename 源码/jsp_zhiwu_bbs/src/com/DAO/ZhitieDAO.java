package com.DAO;

import java.util.List;

import bean.ZhitieBean;

public interface ZhitieDAO {

	/**
	 * ��ѯ�ѷ���������ֲ��
	 * @return
	 * @throws Exception
	 */
	public List queryZhitie() throws Exception;

	/**
	 * ����ֲ��
	 * @param zhitie
	 * @return
	 * @throws Exception
	 */
	public boolean addZhitie(ZhitieBean zhitie) throws Exception;

	/**
	 * ɾ��ֲ��
	 * @param zt_id
	 */
	public void deleteZt(String zt_id) throws Exception;

	/**
	 * ��ѯ�û�ֲ��
	 * @param user_id
	 * @return
	 */
	public List queryMyzt(String user_id) throws Exception;

	/**
	 * ����ֲ��id��ѯֲ��
	 * @param zt_id
	 * @throws Exception
	 */
	public List queryZt(String zt_id) throws Exception;

	/**
	 * ��ѯֲ���ظ���
	 * @param zt_id
	 * @return
	 */
	public List queryHfl(String zt_id) throws Exception;

	/**
	 * ɾ��ֲ����ͬʱɾ������
	 * @param zt_id
	 */
	public void deletePl(String zt_id) throws Exception;

	/**
	 * ����ǰ̨���ص����ݲ�ѯֲ��
	 * @param condition1
	 * @param condition2
	 * @return
	 */
	public List queryZt(String condition1, String condition2) throws Exception;

	/**
	 * ��ѯ���к�content��ص�ֲ��
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public List query(String content) throws Exception;
 
}
