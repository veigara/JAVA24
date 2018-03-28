package com.hxzy;

public class Demo01 {

	/*
	 * static修饰的属性或方法独立于类的对象,通过类名点属性，或类名点方法调用
	 * 被static修饰的属性或方法在类加载到构造器之初就已经存在于内存中。
	 * 
	 * */
	public static String str = "hello";
	public static void aaa() {
		
	}
	
	static{
		/*静态代码块*/
		System.out.println("执行了静态代码块的内容");
	}
	
	{
		/*构造代码块
		 *构造代码块的执行时机高于构造方法 
		 * */
		System.out.println("执行了构造代码块中的代码");
	}
	
	public Demo01(){
		System.out.println("Demo01的构造方法");
	}
	
	
	public void test() {
		int a = 5;
		/*局部代码块*/
		{
			System.out.println("执行局部代码块的内容");
		}
		
	}
	
	public static void main(String[] args) {
		//Demo01 d = new Demo01();
		//d.test();
		
		//调用static修饰的属性或方法
		//String str = Demo01.str;
		//Demo01.aaa();
	}
}
