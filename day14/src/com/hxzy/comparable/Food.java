package com.hxzy.comparable;

public class Food implements Comparable<Food>{
	
	public Food(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	private String name;
	private double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Food other = (Food) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Food food) {
		/*
		 * �����ǰ����ȱȽϵĶ���С���򷵻�-1
		 * �����ǰ����ͱȽϵĶ�����ͬ���򷵻�0
		 * �����ǰ����ȱȽϵĶ�����򷵻�1
		 * */
		
		//�Ƚϵ��Ƕ���
		if (this.equals(food)) {
			return 0;
		}
		return (this.price < food.getPrice()) ? -1 : (this.price == food.getPrice() ? 0 : 1);
	}
	@Override
	public String toString() {
		return "Food [name=" + name + ", price=" + price + "]";
	}
	
}
