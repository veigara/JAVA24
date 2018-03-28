package com.hxzy.�̳߳�;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadpool {

	public static void main(String[] args) {
		/*
		 * �̶���С���̳߳ص���Ŀ���������һ��ֵ��Ӧ�ý��CPU��������Ŀ
		 * ����cpu�������ú��ʵ��߳���
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
			System.out.println("��ǰ�����ţ�" + task_num + "�߳�����Ϊ��" + Thread.currentThread().getName());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
