package com.hxzy.staticProxy;

/**
 * 被代理的类
 * @author Administrator
 *
 */
public class Player implements Game {

	@Override
	public void lvlUp() {
		System.out.println("打怪升级");
	}

}
