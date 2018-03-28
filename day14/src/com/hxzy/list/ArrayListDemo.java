package com.hxzy.list;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
	private static List list = new ArrayList();
	
	static {
		list.add(1);//向集合中添加元素
		list.add(2);
		list.add(3);
		list.add(4);
	}
	
	public static void main(String[] args) {
		//add();
		//foreach();
		//addToIndex();
		remove();
	}
	
	private static void add() {
		
		
		
		System.out.println("list集合长度：" + list.size());
		
	}
	
	/*
	 * 遍历集合中的元素
	 * */
	private static void foreach() {
		/*根据循环三要素遍历集合*/
		/*for (int i = 0; i < list.size(); i++) {
			Integer j = (Integer) list.get(i);//将object强制类型转换成为int的包装类
			System.out.println(j);
		}*/
		
		/*foreach变量集合*/
		/*for(Object item : list) {
			Integer j = (Integer) item;
			System.out.println(j);
		}*/
		
		/*迭代器遍历集合*/
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Integer i = (Integer) it.next();
			System.out.println(i);
		}
	}
	
	/*往指定位置添加元素*/
	private static void addToIndex() {
		list.add(list.size() - 1, 5);
		System.out.println("----插入完毕----");
		foreach();
	}
	
	/*
	 * 删除集合中的元素
	 * 有一个方法的重载：1.根据下表删除集合中的元素    2.根据对象删除元素 
	 * */
	private static void remove() {
		Integer r = (Integer) list.remove(0);
		System.out.println("被删除的元素为：" + r);
		foreach();
	}
}
