package com.hxzy.demo1;

import java.util.List;

/***
 * ģ���ҳ������
 * @author Administrator
 *
 * @param <T>
 */
public class GenericsClass<T> {

	/*��̬���ͷ���*/
	public static <E> void test1(E e) {
		
	}
	
	private List<T> list;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	/*
	 * ����һ�����ͷ���
	 * */
	public T test(T t) {
		return t;
	}
	
	public static void main(String[] args) {
		GenericsClass<String> page = new GenericsClass<>();
		List<String> list2 = page.getList();
	}
}
