package com.hxzy.list;

public class MyArrayList {

	private Object[] element = {};//���ڴ洢����ÿ��Ԫ�صĶ�������
	private final int DEFAULTCAPACITY = 10;//���ϵĳ�ʼ��С
	private int size;  //���漯����ʵ�ʴ洢Ԫ�صĸ���
	public MyArrayList() {
		element = new Object[DEFAULTCAPACITY];
		System.out.println("��ʼ������ɹ�����ǰ����Ϊ��" + DEFAULTCAPACITY);
	}
	
	/*��ʼ��һ��ָ�������ļ���*/
	public MyArrayList(int capacity) {
		if (capacity < 0 || capacity > Integer.MAX_VALUE) {
			element = new Object[DEFAULTCAPACITY];
			System.out.println("��ʼ������ɹ�����ǰ����Ϊ��" + capacity);
		} else {
			element = new Object[capacity];
		}
	}
	
	/**
	 * �򼯺������Ԫ��
	 * @param obj
	 * @return
	 */
	public boolean add(Object obj) {
		//�жϼ����Ƿ���Ҫ����
		ensureCapacity(size + 1);
		element[size++] = obj;
		return true;
	}
	
	private void ensureCapacity(int minCapacity) {
		
		minCapacity = Math.max(DEFAULTCAPACITY, minCapacity);
		
		if (minCapacity - element.length > 0) {
			int oldCapacity = element.length;
			int newCapacity = oldCapacity + (oldCapacity >> 1);//����һ�� 
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			Object[] copy = new Object[newCapacity];//���ݺ��һ����ʱ�Ķ�������
			/*for (int i = 0; i < size; i++) {
				copy[i] = element[i];
			}
			element = copy;*/
			
			/*
			 * System.arraycopy()��������
			 * 1.��Ҫ���Ƶ�Դ����
			 * 2.��Դ�������һ���±꿪ʼ����
			 * 3.Ŀ������
			 * 4.��Ŀ�������ĸ��±꿪ʼ���ܸ���
			 * */
			System.arraycopy(element, 0, copy, 0, element.length);
			element = copy;
			System.out.println("�������ݳɹ�����ǰ����Ϊ��" + newCapacity);
		}
	}
	
	/**
	 * �����±��ȡ�����е�Ԫ��
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		return element[index];
	}
	
	/**
	 * �����±�ɾ��Ԫ��
	 * @param index
	 * @return
	 */
	public boolean remove(int index) {
		if (index < size) {
			//������Ҫ�ƶ���λ��
			int numMoved = size - index - 1;
			if (numMoved > 0) 
				System.arraycopy(element, index + 1, element, index, numMoved);
			element[--size] = null;
			return true;
		}
		return false;
	}
	
	/**
	 * ��ȡ�����д洢Ԫ�ص�ʵ�ʸ���
	 * @return
	 */
	public int size() {
		return size;
	}
}
