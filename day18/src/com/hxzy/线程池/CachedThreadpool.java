package com.hxzy.�̳߳�;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CachedThreadpool {

	public static void main(String[] args) {
		/*����һ�����л�����̳߳أ�����̳߳صĴ�С�����˴�����������Ҫ���̣߳��ͻ���յ�����60���ӿ��е��߳�
		 * �����������ʱ���̳߳ػ��Զ�����߳���������������߳�������JVM�ܹ������̵߳Ĵ�С����
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
			//System.out.println("��ǰ�����ţ�" + task_num + "�߳�����Ϊ��" + Thread.currentThread().getName());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
