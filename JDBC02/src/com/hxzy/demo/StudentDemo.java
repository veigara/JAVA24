package com.hxzy.demo;

import java.util.List;
import java.util.Scanner;

public class StudentDemo {

	public static void main(String[] args) {
		System.out.println("1.���ѧ��2.��������ѯѧ��3.���ݿ���ɾ��ѧ��4.��ѯ����ѧ����Ϣ");
		Scanner input = new Scanner(System.in);
		int choose = input.nextInt();
		StudentManager client = new StudentManager();
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
			int row = client.insert(student); //key�����ش���0��ֵ��˵������ɹ���key����ӵ��������ݵ��������������ʧ��
			System.out.println(row > 0 ?"����ɹ�":"����ʧ��");
		} else if (choose == 2) {
			System.out.println("���������");
			int type = input.nextInt();
			List<Student> list = client.query(type);
			for (Student student : list) {
				System.out.println(student);
			}
		} else if (choose == 3) {
			System.out.println("������Ҫɾ���Ŀ���");
			String examCard = input.next();
			Student stu = new Student();
			stu.setExamCard(examCard);
			int row = client.remove(stu);
			System.out.println(row > 0 ? "ɾ���ɹ���" : "ɾ��ʧ��");
		}
		
		input.close();
	}

}
