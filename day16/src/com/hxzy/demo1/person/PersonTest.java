package com.hxzy.demo1.person;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {

	public static void main(String[] args) {
		Person p = new Person();
		List<LinkManInfo> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		List<BaseInfo> list3 = new ArrayList<>();
		
		p.setList(list1);
		//p.setList(list2);  明白为什么报错
		p.setList(list3);
	}

}
