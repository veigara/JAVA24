package com.hxzy;

public class Demo4 {
	public static void main(String[] args) {
		//test1();
		test2();
	}

	/*
	 * 实参为基本数据类型
	 * */
	private static void test1() {
		int num = 5;//基本数据类型
		change(num);//将num的副本传递进change方法
		System.out.println(num);
	}
	
	private static void change(int num) {
		num = 3;
		System.out.println(num);
	}
	
	/*
	 * 实参为引用数据类型 
	 */
	private static void test2() {
		Num n = new Num();
		System.out.println("Num的值：" + n.num);
		
		change(n);//实参为一个引用数据类型，一个对象
		
		System.out.println("Num的值：" + n.num);
	}
	
	private static void change(Num num) {
		num.num = 3;
		System.out.println("Num的值：" + num.num);
	}
}
