package com.hxzy.test1;

/**
 * �ؿ�С����
 * @author Administrator
 *
 */
public class SmallCar extends Car{
	private int sits;//��λ��

	public int getSits() {
		return sits;
	}

	public void setSits(int sits) {
		this.sits = sits;
	}

	@Override
	public void run() {
		System.out.println("С���������ѣ����ܶ�");
	}
	
}
