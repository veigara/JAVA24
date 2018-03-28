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
	 * 将学生对象插入到数据库中
	 * @param stu
	 * @return
	 */
	public int insert(Student stu) {
		
		String sql = "insert into `examstudent` (type,id_card,exam_card,student_name,location,grade) values(?,?,?,?,?,?)";
		
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);//返回插入后生成的主键
			/*为每个参数化的？设置值*/
			pstmt.setInt(1, stu.getType());
			pstmt.setString(2, stu.getIdCard());
			pstmt.setString(3, stu.getExamCard());
			pstmt.setString(4, stu.getStudentName());
			pstmt.setString(5, stu.getLocation());
			pstmt.setInt(6, stu.getGrade());
			
			/*执行sql语句*/
			pstmt.executeUpdate();//返回受影响的行数
			rs = pstmt.getGeneratedKeys(); //返回插入数据的主键
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
		return 0;//0 代表插入失败
	}
	
	/**
	 * 根据身份证或考号查询学生信息
	 * @param idCard
	 */
	public Student query(String condition) {
		//查询身份证或考号为指定参数的数据
		String sql = "select flow_id,type,id_card,exam_card,student_name,location,grade from `examstudent` t where t.id_card = ? or exam_card = ?";
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, condition);
			pstmt.setString(2, condition);
			
			rs = pstmt.executeQuery(); //得到结果集
			
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
	 * 分页查询全部学生
	 * @param page  页码
	 * @param pageSize  每页显示多少条数据
	 * @return 分页查询的结果
	 */
	public List<Student> queryAll(int page,int pageSize){
		String sql = "select flow_id,type,id_card,exam_card,student_name,location,grade from `examstudent` t limit ?,?";
		
		List<Student> list = new ArrayList<>(); //用于保存分页查询的数据
		
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (page - 1) * pageSize);//排除多少数据
			pstmt.setInt(2, pageSize);//取几条数据
			
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
	 * 根据考号删除学生信息
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
		System.out.println("1.添加学生2.查询学生3.根据考号删除学生4.查询所有学生信息");
		Scanner input = new Scanner(System.in);
		int choose = input.nextInt();
		Client client = new Client();
		if (choose == 1) {
			System.out.println("请输入等级");
			int type = input.nextInt();
			System.out.println("请输入身份证号码");
			String id_card = input.next();
			System.out.println("请输入准考证号码");
			String exam_card = input.next();
			System.out.println("请输入姓名");
			String studentName = input.next();
			System.out.println("请输入区域");
			String location = input.next();
			System.out.println("请输入成绩");
			int grade = input.nextInt();
			Student student = new Student(type, id_card, exam_card, studentName, location, grade);
			int key = client.insert(student); //key并返回大于0的值，说明插入成功，key是添加的这条数据的主键。否则插入失败
			System.out.println(key > 0 ?"插入成功,主键为："  + key :"插入失败");
		} else if (choose == 2) {
			System.out.println("请输入身份证号或准考证号：");
			String param = input.next();
			Student stu = client.query(param);
			//如果查询出来的学生不为null，则输出学生信息
			if (stu != null) System.out.println(stu.toString());
			else System.out.println("查无此人！");
		} else if (choose == 3) {
			System.out.println("请输入准考证号");
			String examCard = input.next();
			Student stu = client.query(examCard);
			if (stu == null) {
				System.out.println("查无此人！");
			}else {
				int row = client.remove(examCard);
				System.out.println(row > 0 ? "删除成功！":"删除失败！");
			}
		} else if (choose == 4) {
			System.out.println("请输入页码:");
			int page = input.nextInt();
			
			List<Student> list = client.queryAll(page, 2);
			
			if (list.size() > 0) {
				for (Student student : list) {
					System.out.println(student.toString());
				}
			} else {
				System.out.println("没有更多数据了!");
			}
		}
		
		input.close();
	}
}
