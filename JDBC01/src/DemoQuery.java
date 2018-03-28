import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoQuery {

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
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);//搭桥，建立连接
			stmt = conn.createStatement(); //创建Statement对象
			
			String sql = "select t2.studentname,t1.studentresult,t3.subjectname from result t1 inner join students t2 on t1.studentno = t2.studentno inner join `subject` t3 on t3.subjectno = t1.subjectno where t2.studentno = 1";
		
			rs = stmt.executeQuery(sql); //调用了executeQuery方法后，得到一个虚拟的结果集
			
			System.out.println("姓名\t\t科目\t\t成绩");
			/*通过循环遍历ResultSet结果集*/
			while (rs.next()) { //只要有下一条数据，next返回的为true
				String studentName = rs.getString(1);//获取结果集中，第一列的值,根据列号获取值
				//rs.getString("studentname");  //根据列名获取值
				double studentResult = rs.getDouble(2);
				//rs.getDouble("studentResult");
				
				String subjectName = rs.getString(3);
				//rs.getString("subjectName");
				System.out.println(studentName + "\t\t" + subjectName + "\t\t" + studentResult);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (stmt != null) {
						stmt.close();
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
