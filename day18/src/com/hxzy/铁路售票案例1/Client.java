package com.hxzy.铁路售票案例1;

public class Client {

	public static void main(String[] args) {
		//模拟4个车站买票
		Train train = new Train();
		
		//4个线程模拟共同售票
		Thread t1 = new Thread(train,"站点1");
		t1.setPriority(10);
		t1.start();
		
		Thread t2 = new Thread(train,"站点2");
		t2.setPriority(1);
		t2.start();
		
		Thread t3 = new Thread(train,"站点3");
		t3.setPriority(1);
		t3.start();
		Thread t4 = new Thread(train,"站点4");
		t4.setPriority(1);
		t4.start();
	}

}
