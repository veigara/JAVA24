package com.hxzy.staticProxy;

/**
 * ������
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
		System.out.println("-----������ʼ����-----");
		game.lvlUp();
		System.out.println("-----������������-----");
	}

}
