package com.hxzy.��ʼ���߳�;

public class DemoThread2 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("DemoThread2���߳�����ִ��");
			/*try {
				Thread.sleep(200);//������Ժ󣬱��߳�����200����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}

	
}
