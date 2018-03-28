package com.hxzy.铁路售票案例2_同步代码块;

public class Train implements Runnable {

	private int ticket = 20;//模拟售20张票
	
	@Override
	public void run() {
		while (ticket > 0) {//循环写在同步代码块之外的目的是为了协调多个线程抢资源
			/*同步代码块*/
			synchronized (this) {
				if (ticket <= 0) {
					return;
				}
				//获取当前执行线程名称
				String name = Thread.currentThread().getName();
				System.out.println(name + "售出一张票,票号" + ticket--);
				try {
					Thread.sleep(100);//休眠100毫秒的作用是模拟代码的耗时操作
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
