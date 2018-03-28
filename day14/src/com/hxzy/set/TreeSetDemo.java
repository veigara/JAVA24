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
		//����treeset�д��ڵ��ڸ���Ԫ�ص���Сֵ
		Food ceiling = ts.ceiling(new Food("test6", 30));
		System.out.println("ceiling:" + ceiling + "\n");
		
		//����treeSet��С�ڵ��ڸ���Ԫ�ص����ֵ
		Food floor = ts.floor(new Food("test7", 998));
		System.out.println("floor:" + floor + "\n");
		
		Food first = ts.first();
		System.out.println("first:" + first + "\n");
		
		Food last = ts.last();
		System.out.println("last:" + last + "\n");
		
		//���ش� set ���ϸ���ڸ���Ԫ�ص���СԪ�أ����������������Ԫ�أ��򷵻� null��
		Food higher = ts.higher(new Food("test6", 30));
		System.out.println("higher:" + higher + "\n");
		
		//���ش� set ���ϸ�С�ڸ���Ԫ�ص����Ԫ�أ����������������Ԫ�أ��򷵻� null��
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
		ts.add(new Fruit("ƻ��", 5));
		ts.add(new Fruit("�㽶", 4.5));
		ts.add(new Fruit("����", 6));
		ts.add(new Fruit("ѩ��", 3));
		
		for (Fruit f : ts) {
			System.out.println(f.toString());
		}
	}
}
