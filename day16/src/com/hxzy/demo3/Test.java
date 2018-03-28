package com.hxzy.demo3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Test {

	public static void main(String[] args) {
		//test1();
		//test2();
		test3();
	}
	
	private static void test3() {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		/*int sum = 0;
		for (Integer integer : list) {
			sum += integer;
		}*/
		Integer integer = list.stream().filter(i->i%2==0).map(i->i*2).reduce((sum,i) -> i+sum).get();
		System.out.println(integer);
	}
	
	private static void test2() {
		List<String> list = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		//查找已J开头的词
		/*for (String s : languages) {
			if (s.startsWith("J")) {
				System.out.println(s);
			}
		}*/
		//filter(list, (i)->i.startsWith("J"));
		//filter(list, (str)->str.length()==3);
		//filter(list, (str)-> str.toUpperCase().equals("LISP"));
		
		List<String> list2 = new ArrayList<>();
		
		list.stream().filter((str)->str.endsWith("a")).forEach(item->list2.add(item));
		list2.forEach(System.out::println);
	}

	public static void filter(List<String> names, Predicate<String> condition) {
	    for(String name: names)  {
	        if(condition.test(name)) {
	            System.out.println(name + " ");
	        }
	    }
	}
	
	private static void test1() {
		List<Integer> list = Arrays.asList(6549,77,8,63,444,936,3215,2);
		//Collections.sort(list);
		
		/*Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return 0;
			}
			
		});*/
		
		Collections.sort(list, (Integer o1, Integer o2)-> o1 - o2 );
		
		list.forEach(System.out::println);
	}

}
