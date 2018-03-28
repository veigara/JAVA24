package com.hxzy.线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
	public static void main(String[] args) {
		
		System.out.println("--------------------准备就绪，即将开始多线程任务--------------------");
		
		int core = Runtime.getRuntime().availableProcessors();
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(core);
		/*
		 * execute()   ExecutorService中的方法，使线程具备可执行状态
		 * schedule(runnable, delay, unit)
		 * 		1.runnable对象
		 * 		2.延迟的时间
		 * 		3.时间单位
		 * 
		 * */
		for (int i = 0; i < 5; i++) {
			executor.schedule(new Task(i), 5L, TimeUnit.SECONDS);
		}
		executor.shutdown();
		System.out.println("--------------------多线程任务执行完毕--------------------");
	}
	public static class Task implements Runnable{
		private int task_num;

		public Task(int task_num) {
			this.task_num = task_num;
		}
		
		@Override
		public void run() {
			System.out.println("当前任务编号：" + task_num + "线程名称为：" + Thread.currentThread().getName());
			/*try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
		
	}
}
