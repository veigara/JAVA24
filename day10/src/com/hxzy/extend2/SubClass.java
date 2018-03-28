package com.hxzy.extend2;

public class SubClass extends SuperClass{

	static {
		System.out.println("子类的静态代码块被执行");
	}
	
	{
		System.out.println("子类的构造代码块被执行");
	}
	
	public SubClass() {
		/*
		 * 实例化子类对象时，子类的构造方法默认会调用父类的无参构造方法
		 * */
		System.out.println("执行了子类的构造方法");
	}
}
