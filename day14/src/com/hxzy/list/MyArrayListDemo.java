package com.hxzy.list;

public class MyArrayListDemo {

	public static void main(String[] args) {
		MyArrayList list = new MyArrayList(1);
		//10 15 22 33 49 73
		for (int i = 0; i < 50; i++) {
			list.add(i + "");
		}
		
		for (int i = 0; i < list.size(); i++) {
			String name = (String) list.get(i);
			System.out.println(name);
		}
	}

}
