package com.hxzy.singleton;

public class Singleton {

	/**
	 * 实现单例模式
	 * 1.构造函数私有化
	 * 2.提供静态的私有的本类的对象
	 * 3.提供公共的静态的方法返回单例的对象(方法名通常都写成getInstance())
	 * 4.单例模式的使用
	 * 		类名.getInstance() 就可以得到单例的对象
	 */
	
	private Singleton() {}
	
	private static Singleton single = null; //懒汉式
	//private static Singleton single = new Singleton();//饿汉式
	
	/**
	 * 同步方法
	 * @return
	 */
	public synchronized static Singleton getInstance() {
		//return single; //和饿汉式搭配使用
		
		//和懒汉式搭配使用
		if (single == null) {
			single = new Singleton();
		}
		return single;
	}
	
}
