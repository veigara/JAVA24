package com.hxzy.demo1;

import java.util.List;

/***
 * 模拟分页工具类
 * @author Administrator
 *
 * @param <T>
 */
public class GenericsClass<T> {

	/*静态泛型方法*/
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
	 * 这是一个泛型方法
	 * */
	public T test(T t) {
		return t;
	}
	
	public static void main(String[] args) {
		GenericsClass<String> page = new GenericsClass<>();
		List<String> list2 = page.getList();
	}
}
