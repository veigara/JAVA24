package com.hxzy.��·��Ʊ����1;

public class Train implements Runnable {

	private int ticket = 20;//ģ����20��Ʊ
	
	@Override
	public void run() {
		while (ticket > 0) {
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
