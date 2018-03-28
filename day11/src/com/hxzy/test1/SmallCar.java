package com.hxzy.test1;

/**
 * 载客小汽车
 * @author Administrator
 *
 */
public class SmallCar extends Car{
	private int sits;//座位数

	public int getSits() {
		return sits;
	}

	public void setSits(int sits) {
		this.sits = sits;
	}

	@Override
	public void run() {
		System.out.println("小汽车先鸣笛，再跑动");
	}
	
}
