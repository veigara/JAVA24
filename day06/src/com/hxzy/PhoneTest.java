package com.hxzy;

public class PhoneTest {

	public static void main(String[] args) {
		Phone phone = new Phone();
		phone.setBrand("samsung");//ͨ����װ����Ϊ���Ը�ֵ
		phone.setPrice(1000);
		
		System.out.println("Ʒ�ƣ�" + phone.getBrand());
		System.out.println("�۸�" + phone.getPrice());
	}

}
