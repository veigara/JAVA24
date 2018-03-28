package com.hxzy;

public class Test2 {

	public static void main(String[] args) {
		
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
		
		Student stu2 = stu1;//将stu1的内存地址复制一份给stu2
		
		stu2.stuNo = "stu002";
		stu2.stuName = "李四";
		
		System.out.println(stu1.stuName);
		System.out.println(stu1.stuNo);
		System.out.println(stu1.stuAge);
		System.out.println(stu1.sex);
		System.out.println();
		
	}

}
