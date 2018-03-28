package com.hxzy.innerClass;

import java.util.HashMap;

import com.hxzy.innerClass.A.B;

public class C {

	/*
	 * 在C类中访问A类中的内部类B
	 * 
	 * B以为对外开放
	 * */
	public static void main(String[] args) {
		/*A a = new A();
		B b = a.new B();
		b.setNum(10);
		System.out.println(b.getNum());*/
		B b = new A().new B();//实例化内部类的步骤
		
		HashMap<String, String> map = new HashMap<>();
	}
	
}
