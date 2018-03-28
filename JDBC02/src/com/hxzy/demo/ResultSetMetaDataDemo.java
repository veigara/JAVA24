package com.hxzy.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetMetaDataDemo {
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
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select t.studentno,t.studentname,t2.studentresult from students t inner join result t2 on t.studentno = t2.studentno";
		//1.创建连接
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			System.out.println("sql语句查询的列数为：" + metaData.getColumnCount());
			System.out.print("sql语句查询的列：");
			for (int i = 0; i < metaData.getColumnCount(); i++) {
				String cName = metaData.getColumnName(i + 1);
				String tabName = metaData.getTableName(i + 1);
				System.out.print("列名：" + cName + ",表名：" + tabName + " ");
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
	}
}
