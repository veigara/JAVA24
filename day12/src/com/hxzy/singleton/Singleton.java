package com.hxzy.singleton;

public class Singleton {

	/**
	 * ʵ�ֵ���ģʽ
	 * 1.���캯��˽�л�
	 * 2.�ṩ��̬��˽�еı���Ķ���
	 * 3.�ṩ�����ľ�̬�ķ������ص����Ķ���(������ͨ����д��getInstance())
	 * 4.����ģʽ��ʹ��
	 * 		����.getInstance() �Ϳ��Եõ������Ķ���
	 */
	
	private Singleton() {}
	
	private static Singleton single = null; //����ʽ
	//private static Singleton single = new Singleton();//����ʽ
	
	/**
	 * ͬ������
	 * @return
	 */
	public synchronized static Singleton getInstance() {
		//return single; //�Ͷ���ʽ����ʹ��
		
		//������ʽ����ʹ��
		if (single == null) {
			single = new Singleton();
		}
		return single;
	}
	
}
