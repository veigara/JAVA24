package com.hxzy.extend;

import java.util.Date;

/**
 * �̳еĹؼ���  extends
 * @author Administrator
 *
 */
public class Student extends Person{

	/**
	 * ѧ������е�����
	 */
	public String school;
	public String name;
	
	public Student() {
		this("",0,null,null);//���ñ����вι��췽��
	}
	
	public Student(String name,int age,Date birthDate,String school) {
		super(name, age, birthDate);
		//super();//���ø�����޲ι��췽��
		/*
		 * Student��̳���Person
		 * ��������ܹ��̳е������˽�е����Ժͷ���(���Լ�û����������������)
		 * 
		 * this:����Ķ���Ҳ���Ե��ø���ĳ�Ա����
		 * super������Ķ���
		 * */
		this.name = name;
		super.name = name;
		
		//this.age = age;
		super.age = age;//ͨ��super���ø���ķ�˽�еĳ�Ա����
		super.getInfo();//ͨ��super���ø����˽�еķ���
		
	}
}
