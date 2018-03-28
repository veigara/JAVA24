package com.hxzy.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadpool {
	public static void main(String[] args) {
		ExecutorService single = Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < 5; i++) {
			/*single.execute(()->{
				
			});*/
			single.execute(new Task(i));
		}
		single.shutdown();
	}
	
	public static class Task implements Runnable{
		private int task_num;

		public Task(int task_num) {
			this.task_num = task_num;
		}
		
		@Override
		public void run() {
			System.out.println("当前任务编号：" + task_num + "线程名称为：" + Thread.currentThread().getName());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
