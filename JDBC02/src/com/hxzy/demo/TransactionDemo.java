package com.hxzy.demo;

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

public class TransactionDemo {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/myschool";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String sql1 = "delete from result where studentno = ?";
		String sql2 = "delete from students where studentno = ?";
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("sql", sql1);
		map1.put("param", new Object[] {0});
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("sql", sql2);
		map2.put("param", new Object[] {0});
		list.add(map1);
		list.add(map2);
		
		doTransaction(list);
	}
	
	/**
	 * 
	 * @param map map�а�������������һ����Ϊsql����Ҫִ�е�sql��䣬�ڶ���ֵΪparameter����Ӧsql���Ĳ���
	 */
	public static void doTransaction(List<Map<String, Object>> list) {
		/*
		 * ��������ɾ��ѧ��Ϊ0��ѧ����Ϣ
		 * ͨ���������ݱ�Ĺ�ϵ����֪studentsѧ����ͳɼ���result�����������ϵ
		 * �����ɾ��ѧ��ʱ��������ɾ���ֱ��е����ݣ�ɾ���ɼ�����ѧ��Ϊ0�����ݺ�ɾ��
		 * ѧ������ѧ��Ϊ0������Ӧ����һ���������
		 * */
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//����jdbcΪ�ֶ��ύ����
			conn.setAutoCommit(false);
			for (Map<String, Object> map : list) {
				String sql = (String) map.get("sql");//��ȡsql���
				Object[] params = (Object[]) map.get("param");
				
				transaction(conn,sql,params);	//ɾ���ɼ�����ѧ��Ϊ0������
				
			}
			conn.commit(); //�ύ����
			conn.setAutoCommit(true);
			System.out.println("ɾ���ɹ���");
		} catch (SQLException e) {
			try {
				conn.rollback();
				System.out.println("ɾ��ʧ��!");
			} catch (SQLException e1) {
				
			}
		} finally {
				try {
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
	}
	
	/**
	 * 
	 * @param conn
	 * @param sql
	 * @param params
	 * @throws SQLException 
	 */
	public static void transaction(Connection conn,String sql,Object...params) throws SQLException {
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
}
