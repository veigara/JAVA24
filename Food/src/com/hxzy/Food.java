package com.hxzy;

/**
 * 食品类
 * @author Administrator
 *
 */
public class Food {
	
	/*
	 * this:本类的对象,当前Food实例的引用
	 * */
	
	private String foodName;//食品名称
	
	private double foodPrice;
	
	//为每个属性设置封装方法
	/**
	 * 为foodName设置
	 * @param foodName
	 */
	public void setFoodName(String foodName) {
		//把局部变量的值赋予给成员变量
		this.foodName = foodName;
	}
	
	/**
	 * 获取foodName的值
	 * @return
	 */
	public String getFoodName() {
		return this.foodName;
	}
	
	/**
	 * 设置foodPrice的值
	 * @param foodPrice
	 */
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	
	/**
	 * 获取foodPrice的值
	 * @return
	 */
	public double getFoodPrice() {
		return this.foodPrice;
	}
}
