import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo3 {
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
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);//��������
			/*
			 * ʹ��prepareStatement() ��ֹsqlע�빥��
			 * ��Ҫ��sql������Ԥ����
			 * 
			 * */
			//��ѯѧ��Ϊ1��ѧԱ��Ϣ
			String sql = "select studentname,loginpwd,sex,studentno from students where studentno = ?";
			pstmt = conn.prepareStatement(sql);
			
			//Ϊsql��������е��ʺø�ֵ
			pstmt.setInt(1, 1); //���ò�ѯѧ��Ϊ1
			
			//ִ��executeQuery������ѯ
			rs = pstmt.executeQuery();
			
			//����resultset����ȡ�����
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
