package com.hxzy.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FruitTest {

	public static void main(String[] args) {
		List<Fruit> list = new ArrayList<>();
		list.add(new Fruit("ƻ��", 5));
		list.add(new Fruit("�㽶", 4.5));
		list.add(new Fruit("����", 6));
		list.add(new Fruit("ѩ��", 3));
		System.out.println("����ǰ��");
		for (Fruit fruit : list) {
			System.out.println(fruit.toString());
		}
		
		System.out.println("\n�����");
		Collections.sort(list, new FruitComparator());
		
		for (Fruit fruit : list) {
			System.out.println(fruit.toString());
		}
	}

}
