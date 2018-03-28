package com.hxzy.template;

public class FaLaLi extends Car {
	
	public FaLaLi(String brand) {
		super(brand);
	}

	@Override
	protected void start() {
		System.out.println(super.getBrand() + "����");
	}

	@Override
	protected void engineBoom() {
		System.out.println(super.getBrand() + "�ķ������ں���");
	}

	@Override
	protected void alarm() {
		System.out.println(super.getBrand() + "����������");
	}

	@Override
	protected void stop() {
		System.out.println(super.getBrand() + "ֹͣ��");
	}

}
