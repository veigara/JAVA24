package com.hxzy.staticProxy;

public class Client {

	public static void main(String[] args) {
		/*
		 * new Player()  被代理的对象
		 * ProxyFacotry 代理负责升级
		 * */
		ProxyFacotry f = new ProxyFacotry(new Player());
		f.lvlUp();//代理帮我们练级
	}

}
