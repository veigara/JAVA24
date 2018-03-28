import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo3 {
	private static final String DRIVER = "com.mysql.jdbc.Driver";  //驱动
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/myschool"; //连接数据库URL
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	static {
		/*加载驱动*/
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
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);//创建连接
			/*
			 * 使用prepareStatement() 防止sql注入攻击
			 * 需要对sql语句进行预定义
			 * 
			 * */
			//查询学号为1的学员信息
			String sql = "select studentname,loginpwd,sex,studentno from students where studentno = ?";
			pstmt = conn.prepareStatement(sql);
			
			//为sql语句中所有的问好赋值
			pstmt.setInt(1, 1); //设置查询学号为1
			
			//执行executeQuery方法查询
			rs = pstmt.executeQuery();
			
			//遍历resultset，获取结果集
			while (rs.next()) {
				String name = rs.getString(1);
				String pwd = rs.getString(2);
				String sex = rs.getString(3);
				int stuno = rs.getInt(4);
				System.out.println(name + "\t" + pwd + "\t" + sex + "\t" + stuno);
			}
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
