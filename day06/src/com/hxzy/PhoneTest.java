package com.hxzy;

public class PhoneTest {

	public static void main(String[] args) {
		Phone phone = new Phone();
		phone.setBrand("samsung");//通过封装方法为属性赋值
		phone.setPrice(1000);
		
		System.out.println("品牌：" + phone.getBrand());
		System.out.println("价格：" + phone.getPrice());
	}

}
