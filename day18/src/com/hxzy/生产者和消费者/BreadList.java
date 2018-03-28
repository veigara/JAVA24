package com.hxzy.生产者和消费者;

import java.util.ArrayList;
import java.util.List;

public class BreadList {

	private static List<Bread> list = new ArrayList<>();
	
	static {
		list.add(new Bread("手撕面包", 12.0));
		list.add(new Bread("黄油面包", 5.0));
		list.add(new Bread("甜甜圈", 8.0));
		list.add(new Bread("菠萝包", 5.0));
		list.add(new Bread("红豆吐司", 12.0));
	}
	
	public static Bread getRandomBread() throws CloneNotSupportedException {
		int index = (int)(Math.random() * 4);
		return list.get(index).clone();
	}
}
