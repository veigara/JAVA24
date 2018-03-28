package com.hxzy_abstractFactory.human;

public abstract class WhiteHuman implements Human {

	@Override
	public void talk() {
		System.out.println("白种人说话是单字节的");
	}

}
