package com.hxzy.铁路售票案例2_同步方法;

public class Client {

	public static void main(String[] args) {
		
		Ticket ticket = new Ticket();
		
		new Thread(new Seller(ticket),"重庆北站北广场").start();
		new Thread(new Seller(ticket),"重庆北站南广场").start();
		new Thread(new Seller(ticket),"重庆西站").start();
		new Thread(new Seller(ticket),"菜园坝火车站").start();
	}

}
