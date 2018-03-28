package com.hxzy.util;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Ignore;
import org.junit.Test;

public class DataSourceUtil {
	
	private static ThreadLocal<Connection> local = new ThreadLocal<>();//当前线程的局部变量，用于托管Connection
	private static DataSource ds;
	
	static {
		Properties prop = new Properties(); //读取dbcp配置文件
		try {
			//因为dbcp.properties没有和DataSourceUtil在一个包中
			prop.load(DataSourceUtil.class.getClassLoader().getResourceAsStream("dbcp.properties"));
			ds = BasicDataSourceFactory.createDataSource(prop); //通过数据源工厂类创建数据源
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据源
	 * @return
	 */
	public static DataSource getDataSource() {
		return ds;
	}
	
	/**
	 * 通过数据源获取连接
	 * @return
	 */
	public static Connection getConnection() {
		
		//先判断Threadlocal中是否已有Connection,如果有，就从Threadlocal中取，否则从连接池中取
		Connection conn = local.get();
		if (conn == null) {
			try {
				conn = ds.getConnection();
				local.set(conn); //将连接池中取到的连接缓存到Threadlocal
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	/**
	 * 开始事务
	 */
	public static void startTransaction() {
		Connection conn = getConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 提交事务
	 */
	public static void commit() {
		Connection conn = local.get();
		if (conn != null) {
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 回滚事务
	 */
	public static void rollback() {
		Connection conn = local.get();
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 关闭连接，释放资源
	 * 注意：此时的conn由dbcp数据源负责维护，因此conn关闭只是将conn归还到连接池中
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public static void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs) {
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
		} finally {
			local.remove();//从本地移除连接
		}
	}
	
	/**
	 * 关闭连接，将连接返还给连接池，并将连接从Threadlocal中移除
	 */
	public static void release() {
		Connection conn = local.get();
		try {
			conn.close();	//归还connection到连接池
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			local.remove(); //连接从Threadlocal中移除
		}
	}
	
	@Test
	@Ignore
	public void checkProp() {
		Properties prop = new Properties();
		try {
			prop.load(DataSourceUtil.class.getClassLoader().getResourceAsStream("dbcp.properties"));
			System.out.println(prop.getProperty("url"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void checkGetDataSource() {
		DataSource data = getDataSource();
		Connection con = null;
		try {
			con = data.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(con);
	}
}
