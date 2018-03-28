package com.hxzy.demo2;

import com.hxzy.demo3.CalcInterface;

public class Test3 {

	public static void main(String[] args) {
		//test1();
		calc((int a,int b) -> a + b);//lambda表达式
	}

	private static void test1() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Before Java8, too much code for too little to do");
			}
		}).start();//开启线程
		
		new Thread(()-> System.out.println("In Java8, Lambda expression rocks !!")).start();;
	}

	public static void calc(CalcInterface c) {
		int add = c.add(5, 10);
		System.out.println(add);
	}
}
