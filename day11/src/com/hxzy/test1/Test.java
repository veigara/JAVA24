package com.hxzy.test1;

public class Test {

	public static void main(String[] args) {
		//ʵ����С����
		SmallCar sc = new SmallCar();
		sc.run();
		sc.stop();
		
		Trucker t = new Trucker();
		t.run();
		t.stop();
	}

}
