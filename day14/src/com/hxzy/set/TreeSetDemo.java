package com.hxzy.set;

import java.util.Comparator;
import java.util.TreeSet;

import com.hxzy.comparable.Food;
import com.hxzy.comparable.Fruit;

public class TreeSetDemo {

	public static void main(String[] args) {
		//comparator();
		comparable();
	}
	
	private static void comparable() {
		TreeSet<Food> ts = new TreeSet<>();
		ts.add(new Food("test1", 1));
		ts.add(new Food("test2", 999));
		ts.add(new Food("test3", 50));
		ts.add(new Food("test4", 43));
		ts.add(new Food("test5", 888));
		
		for (Food f : ts) {
			System.out.println(f.toString());
		}
		System.out.println();
		//返回treeset中大于等于给定元素的最小值
		Food ceiling = ts.ceiling(new Food("test6", 30));
		System.out.println("ceiling:" + ceiling + "\n");
		
		//返回treeSet中小于等于给定元素的最大值
		Food floor = ts.floor(new Food("test7", 998));
		System.out.println("floor:" + floor + "\n");
		
		Food first = ts.first();
		System.out.println("first:" + first + "\n");
		
		Food last = ts.last();
		System.out.println("last:" + last + "\n");
		
		//返回此 set 中严格大于给定元素的最小元素；如果不存在这样的元素，则返回 null。
		Food higher = ts.higher(new Food("test6", 30));
		System.out.println("higher:" + higher + "\n");
		
		//返回此 set 中严格小于给定元素的最大元素；如果不存在这样的元素，则返回 null。
		Food lower = ts.lower(new Food("test7", 998));
		System.out.println("lower:" + lower + "\n");
	}

	private static void comparator() {
		TreeSet<Fruit> ts = new TreeSet<>(new Comparator<Fruit>() {

			@Override
			public int compare(Fruit o1, Fruit o2) {
				if (o1.equals(o2)) {
					return 0;
				}
				return o1.getPrice() < o2.getPrice() ? -1 : (o1.getPrice() == o2.getPrice() ? 0 : 1);
			}
		});
		ts.add(new Fruit("苹果", 5));
		ts.add(new Fruit("香蕉", 4.5));
		ts.add(new Fruit("葡萄", 6));
		ts.add(new Fruit("雪梨", 3));
		
		for (Fruit f : ts) {
			System.out.println(f.toString());
		}
	}
}
