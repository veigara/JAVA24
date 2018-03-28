package com.hxzy.list;

public class MyArrayList {

	private Object[] element = {};//用于存储集合每个元素的对象数组
	private final int DEFAULTCAPACITY = 10;//集合的初始大小
	private int size;  //保存集合中实际存储元素的个数
	public MyArrayList() {
		element = new Object[DEFAULTCAPACITY];
		System.out.println("初始化数组成功，当前长度为：" + DEFAULTCAPACITY);
	}
	
	/*初始化一个指定容量的集合*/
	public MyArrayList(int capacity) {
		if (capacity < 0 || capacity > Integer.MAX_VALUE) {
			element = new Object[DEFAULTCAPACITY];
			System.out.println("初始化数组成功，当前长度为：" + capacity);
		} else {
			element = new Object[capacity];
		}
	}
	
	/**
	 * 向集合中添加元素
	 * @param obj
	 * @return
	 */
	public boolean add(Object obj) {
		//判断集合是否需要扩容
		ensureCapacity(size + 1);
		element[size++] = obj;
		return true;
	}
	
	private void ensureCapacity(int minCapacity) {
		
		minCapacity = Math.max(DEFAULTCAPACITY, minCapacity);
		
		if (minCapacity - element.length > 0) {
			int oldCapacity = element.length;
			int newCapacity = oldCapacity + (oldCapacity >> 1);//扩容一半 
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			Object[] copy = new Object[newCapacity];//扩容后的一个临时的对象数组
			/*for (int i = 0; i < size; i++) {
				copy[i] = element[i];
			}
			element = copy;*/
			
			/*
			 * System.arraycopy()参数含义
			 * 1.需要复制的源数组
			 * 2.从源数组的哪一个下标开始复制
			 * 3.目标数组
			 * 4.从目标数组哪个下标开始接受复制
			 * */
			System.arraycopy(element, 0, copy, 0, element.length);
			element = copy;
			System.out.println("集合扩容成功，当前长度为：" + newCapacity);
		}
	}
	
	/**
	 * 根据下标获取集合中的元素
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		return element[index];
	}
	
	/**
	 * 根据下表删除元素
	 * @param index
	 * @return
	 */
	public boolean remove(int index) {
		if (index < size) {
			//计算需要移动的位数
			int numMoved = size - index - 1;
			if (numMoved > 0) 
				System.arraycopy(element, index + 1, element, index, numMoved);
			element[--size] = null;
			return true;
		}
		return false;
	}
	
	/**
	 * 获取集合中存储元素的实际个数
	 * @return
	 */
	public int size() {
		return size;
	}
}
