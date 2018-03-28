package com.hxzy.demo;

import java.util.List;
import java.util.Scanner;

public class StudentDemo {

	public static void main(String[] args) {
		System.out.println("1.添加学生2.根据类别查询学生3.根据考号删除学生4.查询所有学生信息");
		Scanner input = new Scanner(System.in);
		int choose = input.nextInt();
		StudentManager client = new StudentManager();
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
			int row = client.insert(student); //key并返回大于0的值，说明插入成功，key是添加的这条数据的主键。否则插入失败
			System.out.println(row > 0 ?"插入成功":"插入失败");
		} else if (choose == 2) {
			System.out.println("请输入类别：");
			int type = input.nextInt();
			List<Student> list = client.query(type);
			for (Student student : list) {
				System.out.println(student);
			}
		} else if (choose == 3) {
			System.out.println("请输入要删除的考号");
			String examCard = input.next();
			Student stu = new Student();
			stu.setExamCard(examCard);
			int row = client.remove(stu);
			System.out.println(row > 0 ? "删除成功！" : "删除失败");
		}
		
		input.close();
	}

}
