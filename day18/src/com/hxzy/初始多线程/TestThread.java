package com.hxzy.初始多线程;

public class TestThread {

	/*
	 * main方法成为主线程
	 * */
	public static void main(String[] args) {
		/*
		 * 在主线程中开启的线程成为子线程
		 * */
		Thread t1 = new Thread(new DemoThread1());//创建第一个线程
		t1.start();//开启线程
		
		Thread t2 = new DemoThread2();
		t2.start();//开启线程
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("匿名多线程实现正在执行");
				/*	try {
						Thread.sleep(200);//输出完以后，本线程休眠200毫秒
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
				}
			}
		});
		
		t3.start();//开启线程
		
		for (int i = 0; i < 10; i++) {
			System.out.println("主线程正在执行");
			/*try {
				Thread.sleep(200);//输出完以后，本线程休眠200毫秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}

}
