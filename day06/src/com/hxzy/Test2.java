package com.hxzy;

public class Test2 {

	public static void main(String[] args) {
		
		Student stu1 = new Student();
		
		/*Ϊ���Ը�ֵ*/
		stu1.stuNo = "stu001";
		stu1.stuName = "����";
		stu1.stuAge = 24;
		stu1.sex = '��';
		
		//��ȡ���Ե�ֵ
		System.out.println(stu1.stuName);
		System.out.println(stu1.stuNo);
		System.out.println(stu1.stuAge);
		System.out.println(stu1.sex);
		System.out.println();
		
		Student stu2 = stu1;//��stu1���ڴ��ַ����һ�ݸ�stu2
		
		stu2.stuNo = "stu002";
		stu2.stuName = "����";
		
		System.out.println(stu1.stuName);
		System.out.println(stu1.stuNo);
		System.out.println(stu1.stuAge);
		System.out.println(stu1.sex);
		System.out.println();
		
	}

}
