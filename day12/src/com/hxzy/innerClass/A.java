package com.hxzy.innerClass;

public class A {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//外部类访问内部类的成员
	public void test() {
		double num = new B().getNum();
	}
	
	/*B为A的内部类*/
	public class B{
		private double num;
		private String str = name;//内部类可以访问外部类的私有属性
		public double getNum() {
			return num;
		}

		public void setNum(double num) {
			this.num = num;
		}
	}
}
