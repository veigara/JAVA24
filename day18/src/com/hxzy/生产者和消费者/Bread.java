package com.hxzy.生产者和消费者;

import java.io.Serializable;

public class Bread implements Serializable,Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private Double price;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Bread other = (Bread) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	public Bread(String type, Double price) {
		super();
		this.type = type;
		this.price = price;
	}
	public Bread() {
		super();
	}
	@Override
	public String toString() {
		return "Bread [type=" + type + ", price=" + price + "]";
	}
	@Override
	protected Bread clone() throws CloneNotSupportedException {
		Bread bread = new Bread();
		bread.setPrice(this.getPrice());
		bread.setType(this.getType());
		return bread;
	}
	
	
}
