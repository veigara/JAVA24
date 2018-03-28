package com.hxzy;

public class StudentDemo {
	static {
		System.out.println("静态代码块,带你装逼带你飞");
	}
	
	public static void main(String[] args) {
		System.out.println("我是main方法");
		
		Student s1 = new Student();
		Student s2 = new Student();
	}

}
