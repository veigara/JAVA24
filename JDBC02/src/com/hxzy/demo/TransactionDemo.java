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
	 * @param map map中包含两个键，第一个键为sql，存要执行的sql语句，第二个值为parameter，对应sql语句的参数
	 */
	public static void doTransaction(List<Map<String, Object>> list) {
		/*
		 * 利用事务，删除学号为0的学生信息
		 * 通过分析数据表的关系，已知students学生表和成绩表result存在主外键关系
		 * 因此在删除学生时，必须先删除字表中的数据，删除成绩表中学号为0的数据和删除
		 * 学生表中学号为0的数据应该是一次事务操作
		 * */
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//设置jdbc为手动提交事务
			conn.setAutoCommit(false);
			for (Map<String, Object> map : list) {
				String sql = (String) map.get("sql");//获取sql语句
				Object[] params = (Object[]) map.get("param");
				
				transaction(conn,sql,params);	//删除成绩表中学号为0的数据
				
			}
			conn.commit(); //提交事务
			conn.setAutoCommit(true);
			System.out.println("删除成功！");
		} catch (SQLException e) {
			try {
				conn.rollback();
				System.out.println("删除失败!");
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
