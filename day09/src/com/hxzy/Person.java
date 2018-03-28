package com.hxzy;

/**
 * 人类
 * 所有的人都有的属性
 * 		姓名
 * 		年龄
 * @author Administrator
 *
 */
public class Person {

	private String name;
	
	private int age;
	/*
	 为属性添加封装方法快捷键
	 alt+shift+s
	 generate Getters and Setter
	 选择需要添加封装方法的属性
	 * */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	/*
	 * 这是普通方法，不是构造方法，构造方法没有返回值类型
	 */
	/*public void Person() {
		
	}*/
	
	/**
	 * 无参构造方法
	 */
	public Person() {
		/*
		 * this()
		 * 		调用本类中的无参构造方法
		 * this(实参1,实参2,实参n...)
		 * 		调用本类中的有参构造方法
		 * 
		 * 调用以上两种构造方法时，必须保证写在构造方法中的第一行
		 * */
		this("张三",25);
		System.out.println("实例化Person的对象，正在执行无参构造方法");
		
	}
	
	/**
	 * 初始化Person的对象的同时，为Person的两个属性赋值
	 * @param name
	 * @param age
	 */
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
}
