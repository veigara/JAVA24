package com.hxzy;

public class Phone {

	/*
	 * ʹ�÷�װ
	 * 1.˽�л���Ա����������
	 * 2.�����ṩ�����Ķ����Ը�ֵ�ķ���
	 * 3.�����ṩ�����Ļ�ȡ����ֵ�ķ���
	 * */
	private String brand;//Ʒ��
	
	/**
	 * Ϊ�ֻ�Ʒ�Ƹ�ֵ
	 * @param brand  �ֻ�Ʒ��
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * ��ȡbrandƷ��
	 * @return
	 */
	public String getBrand() {
		return this.brand;
	}
	
	private double price;//�۸�
	
	/**
	 * Ϊ�۸�ֵ
	 * @param price
	 */
	public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		}
	}
	
	/**
	 * ��ȡ�ֻ��۸�
	 * @return
	 */
	public double getPrice() {
		return this.price;
	}
}
