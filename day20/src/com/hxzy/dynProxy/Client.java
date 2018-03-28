package com.hxzy.dynProxy;

import com.hxzy.staticProxy.Game;
import com.hxzy.staticProxy.Player;

public class Client {

	public static void main(String[] args) {
		//1.��ñ�����Ķ���
		RealSubject real = new RealSubject();
		
		//2.�������
		GameProxy proxy = new GameProxy();
		
		//3.ͨ��������õ�������Ķ���
		Subject $proxy0 = (Subject) proxy.blink(real);
		System.out.println($proxy0.getClass().getName());
		//4.Ҫ��������
		$proxy0.action();
		
		System.out.println();
		
		Player player = new Player();
		Game $proxy1 = (Game) proxy.blink(player);
		System.out.println($proxy1.getClass().getName());
		$proxy1.lvlUp();
	}
}
