package com.hxzy3;

import com.hxzy2.PublicDemo;

public class PublicDemoTest {

	public static void main(String[] args) {
		PublicDemo demo = new PublicDemo();
		//new PublicDemo().test();//匿名对象调用方法
		demo.setName("李四");
		System.out.println(demo.stuName);
		
		PublicDemo demo1 = new PublicDemo();
		//new PublicDemo().test();//匿名对象调用方法
		demo1.setName("王五");
		System.out.println(demo1.stuName);
	}

}
