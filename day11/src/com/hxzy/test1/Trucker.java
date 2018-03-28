package com.hxzy.test1;

public class Trucker extends Car {

	private Double capacity;//载重

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	@Override
	public void run() {
		System.out.println("先鸣笛，再启动，再鸣笛");
	}
	
	
}
