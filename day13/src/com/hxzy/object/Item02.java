package com.hxzy.object;

public class Item02 implements Cloneable{

	private String name;
	private int age;
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
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();//浅克隆
		Item02 clone = (Item02) obj;
		clone.setName(new String(this.getName())); //深克隆,通常对应用数据类型进行深克隆
		return clone;
	}
	
	public static void main(String[] args) {
		Item02 it1 = new Item02();
		it1.setName("alice");
		it1.setAge(3);
		try {
			Item02 clone = (Item02) it1.clone();
			System.out.println("内存地址" + (it1 == clone));
			System.out.println("克隆的name和it1的name进行比较：" + (it1.getName() == clone.getName()));
			System.out.println(clone.getName());
			System.out.println(clone.getAge());
			
			it1.setAge(10);//更改it1的age
			it1.setName("爱丽丝");
			System.out.println("修改it1的值以后，展示clone的对象的值是否会受影响");
			System.out.println("it1修改后的名字：" + it1.getName() + "，clone的名字"  +clone.getName());
			System.out.println("it1修改后的年龄：" + it1.getAge() + "，clone的年龄"  +clone.getAge());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
}
