package com.hxzy.守护线程;

/**
 * 守护线程
 * @author Administrator
 *
 */
public class Guardian {
	/**
	 * 守护线程：需要在主线程中声明线程并通过setDaemon(true)
	 * 说明该线程为主线程的守护线程（特殊的子线程）
	 * 特点：随着主线的结束，守护线程随之结束。即使守护线程中的任务没有执行完毕，也需要结束
	 * 使用场景：日志，审计
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("主线程");
		
		//thread为main主线程的子线程
		Thread thread1 = new Thread(()-> {
			while (true) {//此处为了示例，守护线程一直执行下去
				System.out.println("子线程1正在处理任务");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread thread2 = new Thread(()-> {
			while (true) {//此处为了示例，守护线程一直执行下去
				System.out.println("子线程2正在处理任务");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		thread1.setDaemon(true);//设置为main主线程的守护线程
		thread2.setDaemon(true);//设置为main主线程的守护线程
		
		thread1.start();
		thread2.start();
		
		try {
			Thread.sleep(5000);//主线程休眠5秒钟
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main主线程执行完毕");
	}
}
