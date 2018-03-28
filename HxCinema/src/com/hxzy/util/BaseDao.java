package com.hxzy.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;


public class BaseDao {

	private static String DRIVER;
	private static String URL;
	private static String USERNAME;
	private static String PASSWORD;
	
	static {
		
		Properties prop = new Properties();
		try {
			prop.load(BaseDao.class.getResourceAsStream("jdbc.properties"));//ͨ�����·����ȡ�ļ�
			DRIVER = prop.getProperty("jdbc.driver");
			URL = prop.getProperty("jdbc.url");
			USERNAME = prop.getProperty("jdbc.user");
			PASSWORD = prop.getProperty("jdbc.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Class.forName(DRIVER); //ע������
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
	}
	
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	/**
	 * ��������
	 * @return
	 */
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * �ر����ӣ��ͷ���Դ
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ͨ�õ�����ɾ���ĵķ���
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executeUpdate(String sql,Object...params) {
		this.conn = getConnection();//��ȡ����
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			
			/*Ϊsql����в�����ֵ*/
			if (null != params) {
				for (int i = 0; i < params.length; i++) {
					this.pstmt.setObject(i + 1, params[i]);
				}
			}
			//������Ӱ�������
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(this.conn, this.pstmt, null);
		}
		return 0;
	}
	
	/**
	 * ִ������ķ���
	 * �û�ͨ���Զ���HashMap��Ϊ������ÿ��HashMap�б������������
	 * <code>sql<code>��ʾִ�������sql���
	 * <code>param</code>��ʾsql���Ĳ�����null����û�в���
	 * ��������齨��Ϊһ��List
	 * @param list ����HashMap����Ԫ�أ�
	 * @return
	 */
	public boolean doTransaction(List<Map<String, Object>> list) {
		try {
			this.conn = this.getConnection();
			//����jdbcΪ�ֶ��ύ����
			this.conn.setAutoCommit(false);
			for (Map<String, Object> map : list) {
				String sql = (String) map.get("sql");//��ȡsql���
				Object[] params = (Object[]) map.get("param");
				
				transaction(conn,sql,params);	//ɾ���ɼ�����ѧ��Ϊ0������
				
			}
			conn.commit(); //�ύ����
			conn.setAutoCommit(true);
			return true;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				
			}
		} finally {
				this.closeAll(this.conn, this.pstmt, null);
		}
		return false;
	}
	
	/**
	 * 
	 * @param conn
	 * @param sql
	 * @param params
	 * @throws SQLException 
	 */
	private void transaction(Connection conn,String sql,Object...params) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			if (null != params) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
			}
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
	
	/**
	 * 
	 * @param claz ��ѯ���ݿ⣬��ÿ������ӳ���Ϊclaz��Ӧ�Ķ���
	 * @param sql
	 * @param params
	 * @return
	 */
	public <T> List<T> query(Class<T> claz,String sql,Object...params){
		this.conn = this.getConnection();
		List<T> list = new ArrayList<>();
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			if (null != params) { //�жϸ�sql�Ƿ��в���
				for (int i = 0; i < params.length; i++) {
					this.pstmt.setObject(i + 1,params[i]); //Ϊsql�����ÿ��������ֵ
				}
			}
			
			this.rs = this.pstmt.executeQuery();
			
			ResultSetMetaData rsmd = this.rs.getMetaData(); //ͨ���������ȡԪ����
			int columnCount = rsmd.getColumnCount(); //��ȡsql����ѯ�˼�����
			while (this.rs.next()) {
				T obj = claz.newInstance(); //ͨ������ʵ����һ���յĶ���
				for (int i = 0; i < columnCount; i++) {
					Object value = this.rs.getObject(i + 1); //�����кŻ�ȡֵ
					//rsmd.getColumnLabel() ��ȡ���ݿ�����
					String columnName = rsmd.getColumnLabel(i + 1); //�����кô�Ԫ�����л�ȡ�еı��������������ʵ��������Ա���һ��
					BeanUtils.setProperty(obj, columnName, value);
				}
				list.add(obj); //���齫�õĶ�����ӵ�������
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
