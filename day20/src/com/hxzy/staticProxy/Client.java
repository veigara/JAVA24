package com.hxzy.staticProxy;

public class Client {

	public static void main(String[] args) {
		/*
		 * new Player()  ������Ķ���
		 * ProxyFacotry ����������
		 * */
		ProxyFacotry f = new ProxyFacotry(new Player());
		f.lvlUp();//�������������
	}

}
