package com.hxzy.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FruitTest {

	public static void main(String[] args) {
		List<Fruit> list = new ArrayList<>();
		list.add(new Fruit("∆ªπ˚", 5));
		list.add(new Fruit("œ„Ω∂", 4.5));
		list.add(new Fruit("∆œÃ—", 6));
		list.add(new Fruit("—©¿Ê", 3));
		System.out.println("≈≈–Ú«∞£∫");
		for (Fruit fruit : list) {
			System.out.println(fruit.toString());
		}
		
		System.out.println("\n≈≈–Ú∫Û£∫");
		Collections.sort(list, new FruitComparator());
		
		for (Fruit fruit : list) {
			System.out.println(fruit.toString());
		}
	}

}
