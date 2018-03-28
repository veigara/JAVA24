package com.hxzy.���̵�;

/**
 * �������������Ƶ�״̬����
 * @author Administrator
 *
 */
public class LightState {
	//״̬��������ǰ�������ĵƵ�״̬,Ĭ�Ϻ�ƣ�1�����  2���̵�  3���Ƶƣ�
	private Integer state = 1;
	
	/**
	 * �����
	 * @throws Exception 
	 */
	public void redLight() throws Exception {
		synchronized (this) {
			while (state != 1) { //�����ǰ״̬��Ϊ1����˵��������ɫ�ĵ���������˺���߳���Ҫ�ȴ�
				wait();
			}
			for (int i = 0; i < 5; i++) {
				System.out.println("�����" + (i + 1) + "��");
				Thread.sleep(1000);
			}
			state = 2;//��״̬�ĸı�
			
			notifyAll();//���������ȴ����߳�
		}
	}
	
	/**
	 * �̵���
	 * @throws Exception 
	 */
	public void greenLight() throws Exception {
		synchronized (this) {
			while (state != 2) { //�����ǰ״̬��Ϊ1����˵��������ɫ�ĵ�����������̵��߳���Ҫ�ȴ�
				wait();
			}
			for (int i = 0; i < 5; i++) {
				System.out.println("�̵���" + (i + 1) + "��");
				Thread.sleep(1000);
			}
			state = 3;//��״̬�ĸı�
			
			notifyAll();//���������ȴ����߳�
		}
	}
	
	/**
	 * �Ƶ���
	 * @throws Exception 
	 */
	public void yellow() throws Exception {
		synchronized (this) {
			while (state != 3) { //�����ǰ״̬��Ϊ1����˵��������ɫ�ĵ���������˻Ƶ��߳���Ҫ�ȴ�
				wait();
			}
			for (int i = 0; i < 3; i++) {
				System.out.println("�Ƶ���" + (i + 1) + "��");
				Thread.sleep(1000);
			}
			state = 1;//��״̬�ĸı�
			
			notifyAll();//���������ȴ����߳�
		}
	}
}
