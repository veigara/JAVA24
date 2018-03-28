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
			prop.load(BaseDao.class.getResourceAsStream("jdbc.properties"));//通过相对路径获取文件
			DRIVER = prop.getProperty("jdbc.driver");
			URL = prop.getProperty("jdbc.url");
			USERNAME = prop.getProperty("jdbc.user");
			PASSWORD = prop.getProperty("jdbc.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Class.forName(DRIVER); //注册驱动
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
	}
	
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	/**
	 * 建立连接
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
	 * 关闭连接，释放资源
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
	 * 通用的增、删、改的方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executeUpdate(String sql,Object...params) {
		this.conn = getConnection();//获取连接
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			
			/*为sql语句中参数赋值*/
			if (null != params) {
				for (int i = 0; i < params.length; i++) {
					this.pstmt.setObject(i + 1, params[i]);
				}
			}
			//返回受影响的行数
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(this.conn, this.pstmt, null);
		}
		return 0;
	}
	
	/**
	 * 执行事务的方法
	 * 用户通过自定义HashMap作为事务的项，每个HashMap中必须包含两个键
	 * <code>sql<code>表示执行事务的sql语句
	 * <code>param</code>表示sql语句的参数，null代表没有参数
	 * 多个事务组建成为一个List
	 * @param list 中由HashMap构成元素，
	 * @return
	 */
	public boolean doTransaction(List<Map<String, Object>> list) {
		try {
			this.conn = this.getConnection();
			//设置jdbc为手动提交事务
			this.conn.setAutoCommit(false);
			for (Map<String, Object> map : list) {
				String sql = (String) map.get("sql");//获取sql语句
				Object[] params = (Object[]) map.get("param");
				
				transaction(conn,sql,params);	//删除成绩表中学号为0的数据
				
			}
			conn.commit(); //提交事务
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
	 * @param claz 查询数据库，将每行数据映射成为claz对应的对象
	 * @param sql
	 * @param params
	 * @return
	 */
	public <T> List<T> query(Class<T> claz,String sql,Object...params){
		this.conn = this.getConnection();
		List<T> list = new ArrayList<>();
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			if (null != params) { //判断该sql是否有参数
				for (int i = 0; i < params.length; i++) {
					this.pstmt.setObject(i + 1,params[i]); //为sql语句中每个参数赋值
				}
			}
			
			this.rs = this.pstmt.executeQuery();
			
			ResultSetMetaData rsmd = this.rs.getMetaData(); //通过结果集获取元数据
			int columnCount = rsmd.getColumnCount(); //获取sql语句查询了几个列
			while (this.rs.next()) {
				T obj = claz.newInstance(); //通过反射实例化一个空的对象
				for (int i = 0; i < columnCount; i++) {
					Object value = this.rs.getObject(i + 1); //根据列号获取值
					//rsmd.getColumnLabel() 获取数据库列名
					String columnName = rsmd.getColumnLabel(i + 1); //根据列好从元数据中获取列的别名，列名必须和实体类的属性必须一致
					BeanUtils.setProperty(obj, columnName, value);
				}
				list.add(obj); //将组将好的对象添加到集合中
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
