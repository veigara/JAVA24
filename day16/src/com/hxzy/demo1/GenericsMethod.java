package com.hxzy.demo1;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ���ͷ���
 * 
 * @author Administrator
 *
 */
public class GenericsMethod {

	// �ڷǷ��͵����ж��巺�ͷ���

	public <T> T test(T t) {
		return null;
	}

	static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
		for (T o : a) {
			c.add(o);
		}
	}

	public static void main(String[] args) {
		//test1();
		Collection<Object> c = new ArrayList<>();
		c.add(1);//Integer
		c.add("2");//String
		c.add(3.0);//Double
		c.add(new Student("����"));
		c.add(new Student("����"));
		
		test2(c);
	}

	private static void test1() {
		String[] as = new String[20];
		Collection<String> cs = new ArrayList<>();
		fromArrayToCollection(as, cs);
		
		Integer[] is = new Integer[20];
		Collection<Integer> cs2 = new ArrayList<>();
		fromArrayToCollection(is, cs2);
	}
	
	public static void test2(Collection<Object> c) {
		for (Object object : c) {
			System.out.println(object);
		}
	}
}
