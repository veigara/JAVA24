package com.hxzy.��·��Ʊ����2_ͬ������;

public class Client {

	public static void main(String[] args) {
		
		Ticket ticket = new Ticket();
		
		new Thread(new Seller(ticket),"���챱վ���㳡").start();
		new Thread(new Seller(ticket),"���챱վ�Ϲ㳡").start();
		new Thread(new Seller(ticket),"������վ").start();
		new Thread(new Seller(ticket),"��԰�ӻ�վ").start();
	}

}
