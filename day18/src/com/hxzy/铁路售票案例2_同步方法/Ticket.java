package com.hxzy.��·��Ʊ����2_ͬ������;

/**
 * ������Դ��
 * @author Administrator
 *
 */
public class Ticket {
	private int ticket = 20;
	
	public int getTicket() {
		return ticket;
	}

	public synchronized void sell() {
		if (ticket <= 0) {
			System.out.println("����Ʊ����");
			return;
		}
		String name = Thread.currentThread().getName();
		System.out.println(name + "�۳�һ��Ʊ,Ʊ�ţ�" + ticket--);
		/*try {
			Thread.sleep(100);//ģ�⹺Ʊʱ�䣬��Ϊ��Ʊ�������Ͼ���ɵ�
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}
}
