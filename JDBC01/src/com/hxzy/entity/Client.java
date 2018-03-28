package com.hxzy.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
	private static final String DRIVER = "com.mysql.jdbc.Driver" ;
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/myschool";
	private static final String USER = "root";
	private static final String PWD = "root";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ѧ��������뵽���ݿ���
	 * @param stu
	 * @return
	 */
	public int insert(Student stu) {
		
		String sql = "insert into `examstudent` (type,id_card,exam_card,student_name,location,grade) values(?,?,?,?,?,?)";
		
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);//���ز�������ɵ�����
			/*Ϊÿ���������ģ�����ֵ*/
			pstmt.setInt(1, stu.getType());
			pstmt.setString(2, stu.getIdCard());
			pstmt.setString(3, stu.getExamCard());
			pstmt.setString(4, stu.getStudentName());
			pstmt.setString(5, stu.getLocation());
			pstmt.setInt(6, stu.getGrade());
			
			/*ִ��sql���*/
			pstmt.executeUpdate();//������Ӱ�������
			rs = pstmt.getGeneratedKeys(); //���ز������ݵ�����
			while (rs.next()) {
				return rs.getInt(1);
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
		return 0;//0 �������ʧ��
	}
	
	/**
	 * �������֤�򿼺Ų�ѯѧ����Ϣ
	 * @param idCard
	 */
	public Student query(String condition) {
		//��ѯ���֤�򿼺�Ϊָ������������
		String sql = "select flow_id,type,id_card,exam_card,student_name,location,grade from `examstudent` t where t.id_card = ? or exam_card = ?";
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, condition);
			pstmt.setString(2, condition);
			
			rs = pstmt.executeQuery(); //�õ������
			
			while (rs.next()) {
				int flowId = rs.getInt(1);
				int type = rs.getInt(2);
				String idCard = rs.getString(3);
				String examCard = rs.getString(4);
				String name = rs.getString(5);
				String location = rs.getString(6);
				int grade = rs.getInt(7);
				Student stu = new Student(flowId, type, idCard, examCard, name, location, grade);
				return stu;		
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
		return null;
	}
	
	/**
	 * ��ҳ��ѯȫ��ѧ��
	 * @param page  ҳ��
	 * @param pageSize  ÿҳ��ʾ����������
	 * @return ��ҳ��ѯ�Ľ��
	 */
	public List<Student> queryAll(int page,int pageSize){
		String sql = "select flow_id,type,id_card,exam_card,student_name,location,grade from `examstudent` t limit ?,?";
		
		List<Student> list = new ArrayList<>(); //���ڱ����ҳ��ѯ������
		
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (page - 1) * pageSize);//�ų���������
			pstmt.setInt(2, pageSize);//ȡ��������
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int flowId = rs.getInt(1);
				int type = rs.getInt(2);
				String idCard = rs.getString(3);
				String examCard = rs.getString(4);
				String name = rs.getString(5);
				String location = rs.getString(6);
				int grade = rs.getInt(7);
				Student stu = new Student(flowId, type, idCard, examCard, name, location, grade);
				list.add(stu);
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
		return list;
	}
	
	/**
	 * ���ݿ���ɾ��ѧ����Ϣ
	 * @param examCard
	 * @return
	 */
	public int remove(String examCard) {
		String sql = "delete from `examstudent` where exam_card = ?";
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, examCard);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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
		return -1;
	}
	
	
	public static void main(String[] args) {
		System.out.println("1.���ѧ��2.��ѯѧ��3.���ݿ���ɾ��ѧ��4.��ѯ����ѧ����Ϣ");
		Scanner input = new Scanner(System.in);
		int choose = input.nextInt();
		Client client = new Client();
		if (choose == 1) {
			System.out.println("������ȼ�");
			int type = input.nextInt();
			System.out.println("���������֤����");
			String id_card = input.next();
			System.out.println("������׼��֤����");
			String exam_card = input.next();
			System.out.println("����������");
			String studentName = input.next();
			System.out.println("����������");
			String location = input.next();
			System.out.println("������ɼ�");
			int grade = input.nextInt();
			Student student = new Student(type, id_card, exam_card, studentName, location, grade);
			int key = client.insert(student); //key�����ش���0��ֵ��˵������ɹ���key����ӵ��������ݵ��������������ʧ��
			System.out.println(key > 0 ?"����ɹ�,����Ϊ��"  + key :"����ʧ��");
		} else if (choose == 2) {
			System.out.println("���������֤�Ż�׼��֤�ţ�");
			String param = input.next();
			Student stu = client.query(param);
			//�����ѯ������ѧ����Ϊnull�������ѧ����Ϣ
			if (stu != null) System.out.println(stu.toString());
			else System.out.println("���޴��ˣ�");
		} else if (choose == 3) {
			System.out.println("������׼��֤��");
			String examCard = input.next();
			Student stu = client.query(examCard);
			if (stu == null) {
				System.out.println("���޴��ˣ�");
			}else {
				int row = client.remove(examCard);
				System.out.println(row > 0 ? "ɾ���ɹ���":"ɾ��ʧ�ܣ�");
			}
		} else if (choose == 4) {
			System.out.println("������ҳ��:");
			int page = input.nextInt();
			
			List<Student> list = client.queryAll(page, 2);
			
			if (list.size() > 0) {
				for (Student student : list) {
					System.out.println(student.toString());
				}
			} else {
				System.out.println("û�и���������!");
			}
		}
		
		input.close();
	}
}
