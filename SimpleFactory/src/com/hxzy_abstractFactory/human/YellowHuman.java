package com.hxzy_abstractFactory.human;

public abstract class YellowHuman implements Human {

	@Override
	public void talk() {
		System.out.println("黄种说话一般都是双字节的");
	}

}
