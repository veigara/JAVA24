package com.hxzy.Anonymous;

public class AnonymousTest {

	public static void main(String[] args) {
		/*
		 * ����ͽӿڲ��ܱ�ʵ����
		 * */
		Anonymous anonymous = new Anonymous() {
			
			@Override
			public void test2(String str) {
				System.out.println(str);
			}
			
			@Override
			public void test1() {
				System.out.println("test1");
			}
		};
		
		anonymous.test2("test2");
		anonymous.test1();
	}

}
