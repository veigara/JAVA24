package com.hxzy.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CachedThreadpool {

	public static void main(String[] args) {
		/*创建一个具有缓存的线程池，如果线程池的大小超过了处理任务所需要的线程，就会回收掉超过60秒钟空闲的线程
		 * 如果任务增加时，线程池会自动添加线程来处理任务，添加线程上限由JVM能够创建线程的大小决定
		 */
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool(); 
		for (int i = 0; i < 50; i++) {
			executor.execute(new Task(i));
			int corePoolSize = executor.getCorePoolSize();
			int maximumPoolSize = executor.getMaximumPoolSize();
			int activeCount = executor.getActiveCount();
			System.out.println("corePoolSize:" + corePoolSize + ",maximumPoolSize:" + maximumPoolSize + ",activeCount" + activeCount);
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
			//System.out.println("当前任务编号：" + task_num + "线程名称为：" + Thread.currentThread().getName());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
