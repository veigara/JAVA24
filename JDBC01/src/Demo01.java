import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Demo01 {

	//URL:协议：子协议：ip:端口号/数据库名
	private static final String URL ="jdbc:mysql://127.0.0.1:3306/myschool";
	private static final String USER = "root";
	private static final String PWD = "root";
	
	static {
		//通过mysql driver的路径，将mysql驱动加载到程序
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*
			 * 通过Class.forName操作，触发com.mysql.jdbc.Driver中的静态代码块
			 * */
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		try {
			/*建立数据库连接是一个非常费时，非常消耗系统资源的一个过程*/
			connection = DriverManager.getConnection(URL, USER, PWD);
			System.out.println(connection == null ? "建立数据库连接失败":"建立数据库连接成功");
			
			/*创建Statement对象，负责执行sql语句*/
			stmt = connection.createStatement();
			/*
			 * Statement对象包含两个最常用的方法。
			 * 1.executeUpdate(sql)    负责执行DML操作，返回该sql语句在数据中受影响的行数
			 * 2.executeQuery(sql)     负责执行DQL操作，返回ResultSet对象，结果集
			 * */
			String sql = "insert into students (studentName,loginpwd,sex) values('武大郎','123456','男')";
			int row = stmt.executeUpdate(sql);
			System.out.println(row > 0 ?"添加成功":"添加失败");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				/*释放资源*/
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();/*关闭连接，释放资源*/
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
