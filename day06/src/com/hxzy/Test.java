package com.hxzy;

public class Test {

	public static void main(String[] args) {
		//实例化学生的对象
		
		//Scanner input = new Scanner(System.in);
		
		//类型  对象名 = new 类型();
		//数据类型  变量名 = 值;
		//使用了new关键字，说明这是一个应用数据类型
		Student stu1 = new Student();
		
		/*为属性赋值*/
		stu1.stuNo = "stu001";
		stu1.stuName = "明宇";
		stu1.stuAge = 24;
		stu1.sex = '男';
		
		//获取属性的值
		System.out.println(stu1.stuName);
		System.out.println(stu1.stuNo);
		System.out.println(stu1.stuAge);
		System.out.println(stu1.sex);
		System.out.println();
		Student stu2 = new Student();
		/*为属性赋值*/
		stu2.stuNo = "stu002";
		stu2.stuName = "李林松";
		stu2.stuAge = 23;
		stu2.sex = '男';
		//System.out.println(stu1);
		System.out.println(stu2.stuName);
		System.out.println(stu2.stuNo);
		System.out.println(stu2.stuAge);
		System.out.println(stu2.sex);
	}

}
