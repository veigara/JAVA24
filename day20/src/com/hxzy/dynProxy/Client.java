package com.hxzy.dynProxy;

import com.hxzy.staticProxy.Game;
import com.hxzy.staticProxy.Player;

public class Client {

	public static void main(String[] args) {
		//1.获得被代理的对象
		RealSubject real = new RealSubject();
		
		//2.代理的类
		GameProxy proxy = new GameProxy();
		
		//3.通过代理类得到代理类的对象
		Subject $proxy0 = (Subject) proxy.blink(real);
		System.out.println($proxy0.getClass().getName());
		//4.要做的事情
		$proxy0.action();
		
		System.out.println();
		
		Player player = new Player();
		Game $proxy1 = (Game) proxy.blink(player);
		System.out.println($proxy1.getClass().getName());
		$proxy1.lvlUp();
	}
}
