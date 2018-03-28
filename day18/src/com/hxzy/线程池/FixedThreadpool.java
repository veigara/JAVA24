package com.hxzy.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadpool {

	public static void main(String[] args) {
		/*
		 * 固定大小的线程池的数目不是随意的一个值。应该结合CPU来考虑数目
		 * 依据cpu核数设置合适的线程数
		 * */
		int core = Runtime.getRuntime().availableProcessors();
		ExecutorService executor = Executors.newFixedThreadPool(core);
		
		for (int i = 0; i < 5; i++) {
			executor.execute(new Task(i));
		}
		executor.shutdown();
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
