package com.hxzy.�̳߳�;

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
			System.out.println("��ǰ�����ţ�" + task_num + "�߳�����Ϊ��" + Thread.currentThread().getName());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
