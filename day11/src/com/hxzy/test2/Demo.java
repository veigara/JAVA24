package com.hxzy.test2;

public class Demo {

	/*
	 * final 的用法：
	 * 		1.修饰常量，声明时就赋值，一旦赋值，只能取值不能修改常量的值,常量规范大写
	 * 		2.final 修饰类，代表该类为终态，也就是不能够被继承
	 * 				String,Integer
	 * 		3.用final修饰方法，代表方法不能够被重写
	 * 		4.finally
	 * 				只存在于try-catch-finally 结构中，代表捕获异常
	 * 				try{
	 * 				
	 * 				}catch(){
	 * 
	 * 				}finally{
	 * 
	 * 				}
	 * 
	 * */
	public final int MAX_VALUE = Integer.MAX_VALUE;
}
