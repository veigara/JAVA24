package com.hxzy.Anonymous;

public class AbstractClassTest {

	public static void main(String[] args) {
		AbstractClass c = new AbstractClass() {
			
			@Override
			public void test1() {
				System.out.println("ʵ�ֵ�test1����");
			}

			@Override
			public void test2() {
				System.out.println("����д��test2");
			}
		};
		c.test1();
		c.test2();
	}

}
