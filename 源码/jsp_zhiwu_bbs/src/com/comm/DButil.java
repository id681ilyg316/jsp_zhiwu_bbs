package com.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DButil {

	private PreparedStatement state;
	private String url;
	private String user;
	private String password;
	private String classdriver;
	
	public DButil(){
		url = "jdbc:mysql://www.icodedock.com/zhiwu_bbs?useSSL=false&serverTimezone=Asia/Shanghai";
		user = "zhiwu_bbs";
		password = "zhiwu_bbs";
		classdriver = "com.mysql.cj.jdbc.Driver";
	}

	/**
	 * ����ע����Ϣ
	 * ���ݿ�������Ϣ
	 * ��ȡ���ݿ������
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {
		Class.forName(classdriver);      
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("���ݿ����ӳɹ�");
		return conn;
	}
	/**
	 * �ر����ݿ�����
	 * @param conn
	 * @throws SQLException
	 */
	public void close(Connection conn) throws SQLException {
		if(state != null)state.close();
		conn.close();
		System.out.println("���ݿ�ʹ�ùرճɹ�");
	}
	
	/**
	 * ִ�в�ѯ��䣬�Ա����ݿ������޴����ݣ�����ֵΪ������
	 * @param sql
	 * @param parelist
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public boolean excute(String sql, List<Object> parelist, Connection conn) throws SQLException {
		state = conn.prepareStatement(sql);
		for(int i = 0 ; i < parelist.size() ; i++){
			state.setObject(i+1, parelist.get(i));//����ռλ��
		}
		int resnum = state.executeUpdate();
		
		if(resnum > 0) return true;
		else return false;
	}
	
	/**
	 * ִ��SQL����������ֵΪlist��������������
	 * @param sql sql���
	 * @param parelist �������ȡ��ռλ�������Ƽ���
	 * @param conn 
	 * @return
	 * @throws SQLException
	 */
	public List excutequery(String sql, List parelist, Connection conn) throws SQLException {
		List list = new ArrayList();  //�����ǲ�ѯ���
		state = conn.prepareStatement(sql);    //sql��Ԥ����
		if(parelist != null){
			for(int i = 0 ; i < parelist.size() ; i++){
				state.setObject(i+1, parelist.get(i));   //����ռλ����ֵ 
			}
		}
		//����̨�鿴sql����Ƿ���ȷ
//		System.out.println("1res.size()="+list.size());
//		System.out.println("sql="+sql);
//		System.out.println("parelist="+parelist);
		ResultSet set = state.executeQuery();  //ִ��sql��ѯ
		ResultSetMetaData meta = state.getMetaData();  //��ȡ��ǰsql�����ֶ�������
		while(set.next()){
			//������ѯ����� list<map>
			Map map = new HashMap();
			for(int i = 1 ; i <= meta.getColumnCount(); i++ ){
				String key = meta.getColumnName(i);
				map.put(key, set.getString(key));
			}	
			list.add(map);
		}
		System.out.println("���ݿ��ѯʹ�óɹ�!");
		return list;
	}
	public String queryImg(String sql,List parelist,Connection conn) throws SQLException {
		String str="";
		state = conn.prepareStatement(sql);    //sql��Ԥ����
		if(parelist != null){
			for(int i = 0 ; i < parelist.size() ; i++){
				state.setObject(i+1, parelist.get(i));   //����ռλ����ֵ 
			}
		}
		ResultSet set = state.executeQuery();  //ִ��sql��ѯ
		ResultSetMetaData meta = state.getMetaData();  //��ȡ��ǰsql�����ֶ�������
		while(set.next()){
			String key = meta.getColumnName(1);
			str=set.getString(key);
		}
		
		return str;
	}
}
