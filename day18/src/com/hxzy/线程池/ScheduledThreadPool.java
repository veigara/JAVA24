package com.hxzy.�̳߳�;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
	public static void main(String[] args) {
		
		System.out.println("--------------------׼��������������ʼ���߳�����--------------------");
		
		int core = Runtime.getRuntime().availableProcessors();
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(core);
		/*
		 * execute()   ExecutorService�еķ�����ʹ�߳̾߱���ִ��״̬
		 * schedule(runnable, delay, unit)
		 * 		1.runnable����
		 * 		2.�ӳٵ�ʱ��
		 * 		3.ʱ�䵥λ
		 * 
		 * */
		for (int i = 0; i < 5; i++) {
			executor.schedule(new Task(i), 5L, TimeUnit.SECONDS);
		}
		executor.shutdown();
		System.out.println("--------------------���߳�����ִ�����--------------------");
	}
	public static class Task implements Runnable{
		private int task_num;

		public Task(int task_num) {
			this.task_num = task_num;
		}
		
		@Override
		public void run() {
			System.out.println("��ǰ�����ţ�" + task_num + "�߳�����Ϊ��" + Thread.currentThread().getName());
			/*try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
		
	}
}
