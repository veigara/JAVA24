package com.hxzy.staticProxy;

/**
 * 代理类
 * @author Administrator
 *
 */
public class ProxyFacotry implements Game {

	private Game game;
	
	public ProxyFacotry(Game game) {
		super();
		this.game = game;
	}

	@Override
	public void lvlUp() {
		System.out.println("-----代练开始练级-----");
		game.lvlUp();
		System.out.println("-----代练练级结束-----");
	}

}
