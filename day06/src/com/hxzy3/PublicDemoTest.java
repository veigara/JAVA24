package com.hxzy3;

import com.hxzy2.PublicDemo;

public class PublicDemoTest {

	public static void main(String[] args) {
		PublicDemo demo = new PublicDemo();
		//new PublicDemo().test();//����������÷���
		demo.setName("����");
		System.out.println(demo.stuName);
		
		PublicDemo demo1 = new PublicDemo();
		//new PublicDemo().test();//����������÷���
		demo1.setName("����");
		System.out.println(demo1.stuName);
	}

}
