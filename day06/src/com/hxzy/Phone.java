package com.hxzy;

public class Phone {

	/*
	 * 使用封装
	 * 1.私有化成员变量。属性
	 * 2.对外提供公共的对属性赋值的方法
	 * 3.对外提供公公的获取属性值的方法
	 * */
	private String brand;//品牌
	
	/**
	 * 为手机品牌赋值
	 * @param brand  手机品牌
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * 获取brand品牌
	 * @return
	 */
	public String getBrand() {
		return this.brand;
	}
	
	private double price;//价格
	
	/**
	 * 为价格赋值
	 * @param price
	 */
	public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		}
	}
	
	/**
	 * 获取手机价格
	 * @return
	 */
	public double getPrice() {
		return this.price;
	}
}
