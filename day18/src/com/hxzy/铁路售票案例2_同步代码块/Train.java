package com.hxzy.��·��Ʊ����2_ͬ�������;

public class Train implements Runnable {

	private int ticket = 20;//ģ����20��Ʊ
	
	@Override
	public void run() {
		while (ticket > 0) {//ѭ��д��ͬ�������֮���Ŀ����Ϊ��Э������߳�����Դ
			/*ͬ�������*/
			synchronized (this) {
				if (ticket <= 0) {
					return;
				}
				//��ȡ��ǰִ���߳�����
				String name = Thread.currentThread().getName();
				System.out.println(name + "�۳�һ��Ʊ,Ʊ��" + ticket--);
				try {
					Thread.sleep(100);//����100�����������ģ�����ĺ�ʱ����
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
