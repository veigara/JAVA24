package com.hxzy.生产者和消费者;

public class Client {

	public static void main(String[] args) {
		//创建共享资源类对象
		Repository r = new Repository();
		
		//生产者
		Producter p1 = new Producter(r,"面点师张");
		Producter p2 = new Producter(r,"面点师李");
		Producter p3 = new Producter(r,"面点师王");
		
		//消费者
		Customer c1 = new Customer(r, "小飞");
		Customer c2 = new Customer(r, "小李");
		Customer c3 = new Customer(r, "小周");
		Customer c4 = new Customer(r, "小陈");
		Customer c5 = new Customer(r, "小夏");
		Customer c6 = new Customer(r, "小莉");
		
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
