package com.hxzy.铁路售票案例1;

public class Train implements Runnable {

	private int ticket = 20;//模拟售20张票
	
	@Override
	public void run() {
		while (ticket > 0) {
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
