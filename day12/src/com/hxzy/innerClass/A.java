package com.hxzy.innerClass;

public class A {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//�ⲿ������ڲ���ĳ�Ա
	public void test() {
		double num = new B().getNum();
	}
	
	/*BΪA���ڲ���*/
	public class B{
		private double num;
		private String str = name;//�ڲ�����Է����ⲿ���˽������
		public double getNum() {
			return num;
		}

		public void setNum(double num) {
			this.num = num;
		}
	}
}
