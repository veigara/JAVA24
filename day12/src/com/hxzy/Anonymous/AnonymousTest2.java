package com.hxzy.Anonymous;

public class AnonymousTest2 {

	public static void main(String[] args) {
		AnonymousTest2 t = new AnonymousTest2();
		t.test3(new Anonymous() {
			
			@Override
			public void test2(String str) {
				System.out.println("接口中的test2");
			}
			
			@Override
			public void test1() {
				System.out.println("接口中的test1");
			}
		});
		
	}

	public void test3(Anonymous a) {
		a.test1();
	}
}
