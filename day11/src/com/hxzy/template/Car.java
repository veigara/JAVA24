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
	 * run������һ��ģ�巽��
	 */
	public final void run() {
		//ģ�巽��ģʽ������ģ�巽���а���һ���Ĺ����˳����û�������
		this.start();
		this.engineBoom();
		this.alarm();
		this.stop();
	}
}
