package com.hxzy.list;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
	private static List list = new ArrayList();
	
	static {
		list.add(1);//�򼯺������Ԫ��
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
		
		
		
		System.out.println("list���ϳ��ȣ�" + list.size());
		
	}
	
	/*
	 * ���������е�Ԫ��
	 * */
	private static void foreach() {
		/*����ѭ����Ҫ�ر�������*/
		/*for (int i = 0; i < list.size(); i++) {
			Integer j = (Integer) list.get(i);//��objectǿ������ת����Ϊint�İ�װ��
			System.out.println(j);
		}*/
		
		/*foreach��������*/
		/*for(Object item : list) {
			Integer j = (Integer) item;
			System.out.println(j);
		}*/
		
		/*��������������*/
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Integer i = (Integer) it.next();
			System.out.println(i);
		}
	}
	
	/*��ָ��λ�����Ԫ��*/
	private static void addToIndex() {
		list.add(list.size() - 1, 5);
		System.out.println("----�������----");
		foreach();
	}
	
	/*
	 * ɾ�������е�Ԫ��
	 * ��һ�����������أ�1.�����±�ɾ�������е�Ԫ��    2.���ݶ���ɾ��Ԫ�� 
	 * */
	private static void remove() {
		Integer r = (Integer) list.remove(0);
		System.out.println("��ɾ����Ԫ��Ϊ��" + r);
		foreach();
	}
}
