package com.hxzy.�����ߺ�������;

import java.util.ArrayList;
import java.util.List;

public class BreadList {

	private static List<Bread> list = new ArrayList<>();
	
	static {
		list.add(new Bread("��˺���", 12.0));
		list.add(new Bread("�������", 5.0));
		list.add(new Bread("����Ȧ", 8.0));
		list.add(new Bread("���ܰ�", 5.0));
		list.add(new Bread("�춹��˾", 12.0));
	}
	
	public static Bread getRandomBread() throws CloneNotSupportedException {
		int index = (int)(Math.random() * 4);
		return list.get(index).clone();
	}
}
