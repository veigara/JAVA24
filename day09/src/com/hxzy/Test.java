package com.hxzy;

public class Test {

	public static void main(String[] args) {
		
		/*
		 * 构造函数，构造方法，构造器
		 * 构造方法没有返回值类型，方法名和类名完全一样
		 * 构造方法独立于类的对象，构造方法不能够通过对象名来调用
		 * 执行时机：new Person() 创建Person对象时，实质上就是在调用一个构造方法
		 * 
		 * java中，系统默认情况下会赠送一个无参构造方法
		 * 如果用户自定义了一个构造方法（不论无参，还是有参），系统则回收赠送的无参构造
		 * */
		Person p1 = new Person("张三",18);
		p1.setName("张三");
		p1.setAge(18);
		System.out.println("实例化Person对象完毕");
		
	}

}
