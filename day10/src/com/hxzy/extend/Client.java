package com.hxzy.extend;

import java.util.Date;

public class Client {

	public static void main(String[] args) {
		/*
		 * ��֤Person�������Ƿ�̳е��˸�������Ժͷ���
		 * 		����--->����
		 * 
		 * 		����--->������
		 * */
		
		Student stu = new Student();
		stu.age = 18;
		stu.school = "�����ѧ";
		stu.getInfo();
		
		Teacher teacher = new Teacher();
		teacher.name = "����";
		teacher.teachYear = 5;
		teacher.getInfo();
		
		Worker worker = new Worker();
		worker.name = "����";
		worker.birthDate = new Date();//��ǰʱ��
		worker.factory = "��ʿ��";
		worker.getInfo();
		
	}

}
