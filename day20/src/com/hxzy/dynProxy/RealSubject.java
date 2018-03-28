package com.hxzy.dynProxy;

public class RealSubject implements Subject {

	/**
	 * 玩台服的游戏，直连
	 */
	
	@Override
	public void action() {
		System.out.println("连接台服，玩游戏");
	}

}
