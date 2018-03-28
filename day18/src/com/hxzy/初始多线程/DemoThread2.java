package com.hxzy.初始多线程;

public class DemoThread2 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("DemoThread2的线程正在执行");
			/*try {
				Thread.sleep(200);//输出完以后，本线程休眠200毫秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}

	
}
