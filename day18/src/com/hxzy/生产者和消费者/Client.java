package com.hxzy.�����ߺ�������;

public class Client {

	public static void main(String[] args) {
		//����������Դ�����
		Repository r = new Repository();
		
		//������
		Producter p1 = new Producter(r,"���ʦ��");
		Producter p2 = new Producter(r,"���ʦ��");
		Producter p3 = new Producter(r,"���ʦ��");
		
		//������
		Customer c1 = new Customer(r, "С��");
		Customer c2 = new Customer(r, "С��");
		Customer c3 = new Customer(r, "С��");
		Customer c4 = new Customer(r, "С��");
		Customer c5 = new Customer(r, "С��");
		Customer c6 = new Customer(r, "С��");
		
		new Thread(p1,p1.getName()).start();
		new Thread(p2,p2.getName()).start();
		new Thread(p3,p3.getName()).start();
		
		new Thread(c1,c1.getName()).start();
		new Thread(c2,c2.getName()).start();
		new Thread(c3,c3.getName()).start();
		new Thread(c4,c4.getName()).start();
		new Thread(c5,c5.getName()).start();
		new Thread(c6,c6.getName()).start();
	}

}
