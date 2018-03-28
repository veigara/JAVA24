package com.hxzy.test1;

/**
 * 汽车的抽象类
 * 
 * 1.抽象类使用abstract修饰
 * 2.抽象类不能被实例化
 * 3.抽象类中可以包含普通方法以及抽象方法
 * @author Administrator
 *
 */
public abstract class Car {
	
	//为类添加构造函数的快捷键   alt+shift+s
	
	
	private String brand;//品牌
	
	public Car(String brand, Double price) {
		super();
		this.brand = brand;
		this.price = price;
	}
	
	public Car() {
		super();
		System.out.println("调用抽象的父类的无参构造方法");
	}

	private Double price;//价格

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
	 * 抽象方法,抽象方法没有方法体，相当于一种能力。具体的实现应该交由子类实现
	 * 
	 * 
	 * 1.抽象方法是用abstract修饰
	 * 2.抽象方法没有方法体（虚方法）
	 * 3.抽象方法必须存在于抽象类中
	 * 4.抽象方法必须在子类中实现，除非子类也是一个抽象类
	 * 5.不能用abstract修饰属性、私有方法、构造器、静态方法、final的方法。
	 */
	public abstract void run();
	
	/**
	 * final修饰的方法不能够被子类重写
	 */
	public final void stop() {
		System.out.println("汽车停止");
	}
	
}
