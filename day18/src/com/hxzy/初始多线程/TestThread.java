package com.hxzy.��ʼ���߳�;

public class TestThread {

	/*
	 * main������Ϊ���߳�
	 * */
	public static void main(String[] args) {
		/*
		 * �����߳��п������̳߳�Ϊ���߳�
		 * */
		Thread t1 = new Thread(new DemoThread1());//������һ���߳�
		t1.start();//�����߳�
		
		Thread t2 = new DemoThread2();
		t2.start();//�����߳�
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("�������߳�ʵ������ִ��");
				/*	try {
						Thread.sleep(200);//������Ժ󣬱��߳�����200����
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
				}
			}
		});
		
		t3.start();//�����߳�
		
		for (int i = 0; i < 10; i++) {
			System.out.println("���߳�����ִ��");
			/*try {
				Thread.sleep(200);//������Ժ󣬱��߳�����200����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}

}
