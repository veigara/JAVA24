package com.hxzy.list;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {
		Set set = new HashSet<>();
		
		/*向HashSet中插入元素*/
		set.add("a");
		set.add("hello");
		set.add("world");
		set.add("!");
		set.add("123");
		set.add("test");
		set.add("111");
		boolean bool = set.add("a");
		System.out.println(bool);
		
		/*遍历hashSet*/
		/*for (Object item : set) {
			String str = (String) item;
			System.out.println(str);
		}*/
		
		/*
		 * 通过迭代器遍历HashSet
		 * 
		 * 迭代器通常和while循环搭配使用
		 * */
		Iterator it = set.iterator(); //获取迭代器
		
		while (it.hasNext()) {
			String item = (String) it.next();
			System.out.println(item);
		}
	}

}
