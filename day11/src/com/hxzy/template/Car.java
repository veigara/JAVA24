package com.hxzy.template;

public abstract class Car {

	private String brand;
		
	public Car(String brand) {
		super();
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}

	protected abstract void start();
	
	protected abstract void engineBoom();
	
	protected abstract void alarm();
	
	protected abstract void stop();
	
	/**
	 * run方法是一个模板方法
	 */
	public final void run() {
		//模板方法模式就是在模板方法中按照一个的规则和顺序调用基本方法
		this.start();
		this.engineBoom();
		this.alarm();
		this.stop();
	}
}
