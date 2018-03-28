package com.hxzy.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		List list2 = new LinkedList();
		
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.addFirst("e");
		
		/*for (Object item : list) {
			String str = (String) item;
			System.out.println(str);
		}*/
		Iterator it = list.iterator();
		while (it.hasNext()) {
			String str = (String) it.next();
			System.out.println(str);
		}
	}

}
