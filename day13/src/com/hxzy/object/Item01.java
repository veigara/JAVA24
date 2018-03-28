package com.hxzy.object;

public class Item01 {
	
	private String str1;
	private int num1;
	
	public String getStr1() {
		return str1;
	}
	public void setStr1(String str1) {
		this.str1 = str1;
	}

	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}

	//重写Object中的equals方法
	
	
	public static void main(String[] args) {
		Item01 it1 = new Item01();
		it1.setNum1(10);
		Item01 it2 = new Item01();
		it2.setNum1(5);
		
		System.out.println(it1);
		System.out.println(it2);
		//比较it1和it2的内存地址
		System.out.println(it1.equals(it2));
		
		
		String str = "";
		System.out.println(it1.equals(str));
		
		String str2 = "123";
		String str3 = "hello";
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		
		System.out.println("-----------------------");
		System.out.println("it1和it2的内存地址比较" + it1.equals(it2));
		System.out.println("it1的hashcode:" + it1.hashCode());
		System.out.println("it2的hashcode:" + it2.hashCode());
		
		System.out.println("-----------toString------------");
		System.out.println(it1.toString());
		System.out.println(it2.toString());
	}
	/*@Override
	public boolean equals(Object obj) {
		//判断obj是否为Item01的类型
		if (!(obj instanceof Item01)) {//判断obj是否为Item01的实例
			return false;//说明obj不是Item01的对象
		}
		if (this != obj) { //内存地址不相同，则返回false
			return false;
		} 
		
		Item01 temp = (Item01) obj;
		if (this.str1.equals(temp.getStr1()) && this.num1 == temp.getNum1()) {
				return true;
		}
		
		return false;
	}*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num1;
		result = prime * result + ((str1 == null) ? 0 : str1.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item01 other = (Item01) obj;
		if (num1 != other.num1)
			return false;
		if (str1 == null) {
			if (other.str1 != null)
				return false;
		} else if (!str1.equals(other.str1))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "str1:" + str1 + ",num1:" + num1;
	}
	
	
}
