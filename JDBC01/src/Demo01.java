import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Demo01 {

	//URL:Э�飺��Э�飺ip:�˿ں�/���ݿ���
	private static final String URL ="jdbc:mysql://127.0.0.1:3306/myschool";
	private static final String USER = "root";
	private static final String PWD = "root";
	
	static {
		//ͨ��mysql driver��·������mysql�������ص�����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*
			 * ͨ��Class.forName����������com.mysql.jdbc.Driver�еľ�̬�����
			 * */
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		try {
			/*�������ݿ�������һ���ǳ���ʱ���ǳ�����ϵͳ��Դ��һ������*/
			connection = DriverManager.getConnection(URL, USER, PWD);
			System.out.println(connection == null ? "�������ݿ�����ʧ��":"�������ݿ����ӳɹ�");
			
			/*����Statement���󣬸���ִ��sql���*/
			stmt = connection.createStatement();
			/*
			 * Statement�������������õķ�����
			 * 1.executeUpdate(sql)    ����ִ��DML���������ظ�sql�������������Ӱ�������
			 * 2.executeQuery(sql)     ����ִ��DQL����������ResultSet���󣬽����
			 * */
			String sql = "insert into students (studentName,loginpwd,sex) values('�����','123456','��')";
			int row = stmt.executeUpdate(sql);
			System.out.println(row > 0 ?"��ӳɹ�":"���ʧ��");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				/*�ͷ���Դ*/
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();/*�ر����ӣ��ͷ���Դ*/
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
