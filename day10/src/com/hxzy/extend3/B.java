package com.hxzy.extend3;

public class B extends A {


	
	/*
	 * 1.子类继承了父类
	 * 2.方法名，参数列表，返回值类型要和父类一致
	 * 3.子类重写的方法访问修饰符级别不能够比父类更低
	 * 
	 * 重写父类方法的快捷键
	 * alt+shift+s
	 * Override/Implements Methods
	 * */
	@Override
	public void a() {
		System.out.println("b");
	}
}
