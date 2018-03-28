package com.hxzy.template;

public class FaLaLi extends Car {
	
	public FaLaLi(String brand) {
		super(brand);
	}

	@Override
	protected void start() {
		System.out.println(super.getBrand() + "启动");
	}

	@Override
	protected void engineBoom() {
		System.out.println(super.getBrand() + "的发动机在轰鸣");
	}

	@Override
	protected void alarm() {
		System.out.println(super.getBrand() + "的喇叭在响");
	}

	@Override
	protected void stop() {
		System.out.println(super.getBrand() + "停止了");
	}

}
