package com.hxzy;

public class Test {

	public static void main(String[] args) {
		//ʵ����ѧ���Ķ���
		
		//Scanner input = new Scanner(System.in);
		
		//����  ������ = new ����();
		//��������  ������ = ֵ;
		//ʹ����new�ؼ��֣�˵������һ��Ӧ����������
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
		Student stu2 = new Student();
		/*Ϊ���Ը�ֵ*/
		stu2.stuNo = "stu002";
		stu2.stuName = "������";
		stu2.stuAge = 23;
		stu2.sex = '��';
		//System.out.println(stu1);
		System.out.println(stu2.stuName);
		System.out.println(stu2.stuNo);
		System.out.println(stu2.stuAge);
		System.out.println(stu2.sex);
	}

}
