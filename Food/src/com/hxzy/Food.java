package com.hxzy;

/**
 * ʳƷ��
 * @author Administrator
 *
 */
public class Food {
	
	/*
	 * this:����Ķ���,��ǰFoodʵ��������
	 * */
	
	private String foodName;//ʳƷ����
	
	private double foodPrice;
	
	//Ϊÿ���������÷�װ����
	/**
	 * ΪfoodName����
	 * @param foodName
	 */
	public void setFoodName(String foodName) {
		//�Ѿֲ�������ֵ�������Ա����
		this.foodName = foodName;
	}
	
	/**
	 * ��ȡfoodName��ֵ
	 * @return
	 */
	public String getFoodName() {
		return this.foodName;
	}
	
	/**
	 * ����foodPrice��ֵ
	 * @param foodPrice
	 */
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	
	/**
	 * ��ȡfoodPrice��ֵ
	 * @return
	 */
	public double getFoodPrice() {
		return this.foodPrice;
	}
}
