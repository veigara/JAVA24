package com.hxzy.�ػ��߳�;

/**
 * �ػ��߳�
 * @author Administrator
 *
 */
public class Guardian {
	/**
	 * �ػ��̣߳���Ҫ�����߳��������̲߳�ͨ��setDaemon(true)
	 * ˵�����߳�Ϊ���̵߳��ػ��̣߳���������̣߳�
	 * �ص㣺�������ߵĽ������ػ��߳���֮��������ʹ�ػ��߳��е�����û��ִ����ϣ�Ҳ��Ҫ����
	 * ʹ�ó�������־�����
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("���߳�");
		
		//threadΪmain���̵߳����߳�
		Thread thread1 = new Thread(()-> {
			while (true) {//�˴�Ϊ��ʾ�����ػ��߳�һֱִ����ȥ
				System.out.println("���߳�1���ڴ�������");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread thread2 = new Thread(()-> {
			while (true) {//�˴�Ϊ��ʾ�����ػ��߳�һֱִ����ȥ
				System.out.println("���߳�2���ڴ�������");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		thread1.setDaemon(true);//����Ϊmain���̵߳��ػ��߳�
		thread2.setDaemon(true);//����Ϊmain���̵߳��ػ��߳�
		
		thread1.start();
		thread2.start();
		
		try {
			Thread.sleep(5000);//���߳�����5����
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main���߳�ִ�����");
	}
}
