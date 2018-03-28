package com.hxzy.extend;

import java.util.Date;

/**
 * 继承的关键字  extends
 * @author Administrator
 *
 */
public class Student extends Person{

	/**
	 * 学生类独有的属性
	 */
	public String school;
	public String name;
	
	public Student() {
		this("",0,null,null);//调用本类有参构造方法
	}
	
	public Student(String name,int age,Date birthDate,String school) {
		super(name, age, birthDate);
		//super();//调用父类的无参构造方法
		/*
		 * Student类继承自Person
		 * 因此子类能够继承到父类非私有的属性和方法(在自己没有这个变量的情况下)
		 * 
		 * this:本类的对象，也可以调用父类的成员变量
		 * super：父类的对象
		 * */
		this.name = name;
		super.name = name;
		
		//this.age = age;
		super.age = age;//通过super调用父类的非私有的成员变量
		super.getInfo();//通过super调用父类非私有的方法
		
	}
}
