package com.hxzy.list;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {
		Set set = new HashSet<>();
		
		/*��HashSet�в���Ԫ��*/
		set.add("a");
		set.add("hello");
		set.add("world");
		set.add("!");
		set.add("123");
		set.add("test");
		set.add("111");
		boolean bool = set.add("a");
		System.out.println(bool);
		
		/*����hashSet*/
		/*for (Object item : set) {
			String str = (String) item;
			System.out.println(str);
		}*/
		
		/*
		 * ͨ������������HashSet
		 * 
		 * ������ͨ����whileѭ������ʹ��
		 * */
		Iterator it = set.iterator(); //��ȡ������
		
		while (it.hasNext()) {
			String item = (String) it.next();
			System.out.println(item);
		}
	}

}
