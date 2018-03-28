package com.hxzy.�����ߺ�������;

import java.util.List;
import java.util.Vector;

public class Repository {

	//����Ĳֿ⣬���ֻ�ܴ�100
	private List<Bread> list = new Vector<>();
	
	public final int CAPACITY = 10;//�ֿ���������Ϊ100
	
	/**
	 * �������
	 * @throws Exception 
	 */
	public synchronized void makeBread() throws Exception {
		String name = Thread.currentThread().getName();//��ȡ��ǰ�����ߵ�����
		while (this.list.size() >= CAPACITY) { //�������������ﵽ���ޣ�������ȴ�
			System.out.println("���ﵽ���ޣ�"+name+"ֹͣ�������ȴ�����");
			wait();
		}
		
		Bread bread = BreadList.getRandomBread();//��ȡ��������
		this.list.add(bread);
		
		System.out.println(name + "������һ��" + bread.getType());
		
		notifyAll();//�������д��ڵȴ����߳�
	}
	
	/**
	 * ���ѣ��������
	 * @throws InterruptedException 
	 */
	public synchronized void buy() throws InterruptedException {
		/*
		 * �����һ��ִ�У������������߳�������Դ�����Ǵ�ʱ�ļ�����û�п������
		 * ��ˣ���������Ҫ�ȴ��������������
		 * */
		String name = Thread.currentThread().getName();
		while (this.list.size() <= 0) {
			System.out.println("��ǰ��治�㣬" + name + "�ȴ�����");
			wait();//����������ѣ���ȴ�
		}
		Bread bread = this.list.remove(0);
		System.out.println(name + "�����ˣ�" + bread.toString());
		
		notifyAll();//�������е��̣߳������������̣߳�
	}
}
