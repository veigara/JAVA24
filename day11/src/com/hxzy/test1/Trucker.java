package com.hxzy.test1;

public class Trucker extends Car {

	private Double capacity;//����

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	@Override
	public void run() {
		System.out.println("�����ѣ���������������");
	}
	
	
}
