package com.hxzy.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public class TestFood {

	public static void main(String[] args) {
		
		List<Food> list = new ArrayList<>();
		list.add(new Food("test1", 1));
		list.add(new Food("test2", 999));
		list.add(new Food("test3", 50));
		list.add(new Food("test4", 43));
		list.add(new Food("test5", 888));
		System.out.println("≈≈–Ú«∞£∫");
		/*Iterator<Food> iterator = list.iterator();
		while (iterator.hasNext()) {
			Food food = iterator.next();
			System.out.println(food.toString());
		}*/
		/*
		 * for(;;){
		 * 
		 * }
		 * */
		for (Iterator<Food> iterator = list.iterator(); iterator.hasNext();) {
			Food food = iterator.next();
			System.out.println(food.toString());
			
		}
		
		/*Collections.sort(list);
		System.out.println("\n≈≈–Ú∫Û£∫");
		iterator = list.iterator();
		while (iterator.hasNext()) {
			Food food = iterator.next();
			System.out.println(food.toString());
		}*/
	}

}
