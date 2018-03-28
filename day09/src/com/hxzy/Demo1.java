package com.hxzy;

public class Demo1 {
	
	public static void main(String[] args) {
		System.out.println();
		System.out.println(false);
		System.out.println(3);
		System.out.println(3.14);
		System.out.println("hello world");
		/*
		 * System.out.println(); println()方法就是一个方法的重载
		 * 
		 * 在一个类中，存在一个或多个方法名相同，参数列表不同，与访问修饰符和返回值类型无关则形成了方法的重载
		 * */
	}
	
	public void a() {
		
	}
	
	int a(int a) {
		return 0;
	}
	
	private String a(int a,int b) {
		return null;
	}
	
	public void a(double b) {
		
	}
}
