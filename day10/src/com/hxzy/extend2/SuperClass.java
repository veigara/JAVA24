package com.hxzy.extend2;

public class SuperClass {
	
	static {
		System.out.println("父类的静态代码块被执行");
	}
	
	{
		System.out.println("父类的构造代码块被执行");
	}
	
	public SuperClass() {
		System.out.println("执行了父类的构造方法");
	}
	
	public SuperClass(String name) {}
}
