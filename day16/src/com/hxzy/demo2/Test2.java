package com.hxzy.demo2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Test2 {

	public static void main(String[] args) {
		String[] a = { "17", "52", "33", "412", "59", "62", "71" };
		List<String> list = Arrays.asList(a);
		/*for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();*/
		
		/*for (String item : list) {
			System.out.print(item + " ");
		}*/
		
		/*Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}*/
		
		//list.forEach(i -> System.out.println(i));
		
		//list.forEach(System.out::println);
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
	}

}
