package com.hxzy;

public class Demo2 {

	public int methodOne(int param1) {
		
		return param1 * param1;
	}
	
	public void methodOne(int param1,int param2) {
		int num1 = param1 * param1;
		int num2 = (int) Math.pow(param2, 2);
		System.out.println("param1的平方：" + num1);
		System.out.println("param2的平方：" + num2);
	}
	
	/**
	 * 
	 * @param num 是一个字符串类型的数字    "123"  "345"  "1.23"   "abc" "hello"
	 * @return
	 */
	public int methodOne(String str) {
		//将字符串类型的数字转换成为int或者是double
		//int num1 = (int)num; //因为String和数值类型不兼容，所以不满足自动类型转换和强制类型转换
		
		//使用基本数据类型的包装类
		/*
		 * int,double基本数据类型，基本数据类型没有方法
		 * java中提供了很多个包装类
		 * int--->java.lang.Integer
		 * double--->java.lang.Double
		 * */
		int maxValue = Integer.MAX_VALUE;//2^31 -1
		int minValue = Integer.MIN_VALUE;//-2^31
		int num = Integer.valueOf(str);//将字符串数字转换成为Integer
		return num * num;
	}
	
	public static void main(String[] args) {
		int i = 100869;//01000
		System.out.println(Integer.toBinaryString(i));//将int类型的值转换成为字符串的二进制
		System.out.println(Integer.toHexString(i));//将int类型的值转换成为字符串的十六进制
		
		/*
		 * Integer.valueOf()和Integer.parseInt()的区别
		 * */
		System.out.println();
		String str = "abc";
		int num = Integer.valueOf(str);
		int num2 = Integer.parseInt(str);
		//System.out.println("Integer.valueOf:" + num);
		System.out.println("Integer.parseInt" + num2);
	}
}
