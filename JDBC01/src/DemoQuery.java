import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoQuery {

	private static final String DRIVER = "com.mysql.jdbc.Driver";  //����
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/myschool"; //�������ݿ�URL
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	static {
		/*��������*/
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
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);//���ţ���������
			stmt = conn.createStatement(); //����Statement����
			
			String sql = "select t2.studentname,t1.studentresult,t3.subjectname from result t1 inner join students t2 on t1.studentno = t2.studentno inner join `subject` t3 on t3.subjectno = t1.subjectno where t2.studentno = 1";
		
			rs = stmt.executeQuery(sql); //������executeQuery�����󣬵õ�һ������Ľ����
			
			System.out.println("����\t\t��Ŀ\t\t�ɼ�");
			/*ͨ��ѭ������ResultSet�����*/
			while (rs.next()) { //ֻҪ����һ�����ݣ�next���ص�Ϊtrue
				String studentName = rs.getString(1);//��ȡ������У���һ�е�ֵ,�����кŻ�ȡֵ
				//rs.getString("studentname");  //����������ȡֵ
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
