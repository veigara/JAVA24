package com.hxzy.test1;

/**
 * �����ĳ�����
 * 
 * 1.������ʹ��abstract����
 * 2.�����಻�ܱ�ʵ����
 * 3.�������п��԰�����ͨ�����Լ����󷽷�
 * @author Administrator
 *
 */
public abstract class Car {
	
	//Ϊ����ӹ��캯���Ŀ�ݼ�   alt+shift+s
	
	
	private String brand;//Ʒ��
	
	public Car(String brand, Double price) {
		super();
		this.brand = brand;
		this.price = price;
	}
	
	public Car() {
		super();
		System.out.println("���ó���ĸ�����޲ι��췽��");
	}

	private Double price;//�۸�

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * ���󷽷�,���󷽷�û�з����壬�൱��һ�������������ʵ��Ӧ�ý�������ʵ��
	 * 
	 * 
	 * 1.���󷽷�����abstract����
	 * 2.���󷽷�û�з����壨�鷽����
	 * 3.���󷽷���������ڳ�������
	 * 4.���󷽷�������������ʵ�֣���������Ҳ��һ��������
	 * 5.������abstract�������ԡ�˽�з���������������̬������final�ķ�����
	 */
	public abstract void run();
	
	/**
	 * final���εķ������ܹ���������д
	 */
	public final void stop() {
		System.out.println("����ֹͣ");
	}
	
}
