package com.hxzy.extend;

import java.util.Date;

public class Client {

	public static void main(String[] args) {
		/*
		 * 验证Person的子类是否继承到了父类的属性和方法
		 * 		父类--->子类
		 * 
		 * 		基类--->派生类
		 * */
		
		Student stu = new Student();
		stu.age = 18;
		stu.school = "重庆大学";
		stu.getInfo();
		
		Teacher teacher = new Teacher();
		teacher.name = "张三";
		teacher.teachYear = 5;
		teacher.getInfo();
		
		Worker worker = new Worker();
		worker.name = "王五";
		worker.birthDate = new Date();//当前时间
		worker.factory = "富士康";
		worker.getInfo();
		
	}

}
