package com.hxzy;

/**
 * ����
 * ���е��˶��е�����
 * 		����
 * 		����
 * @author Administrator
 *
 */
public class Person {

	private String name;
	
	private int age;
	/*
	 Ϊ������ӷ�װ������ݼ�
	 alt+shift+s
	 generate Getters and Setter
	 ѡ����Ҫ��ӷ�װ����������
	 * */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	/*
	 * ������ͨ���������ǹ��췽�������췽��û�з���ֵ����
	 */
	/*public void Person() {
		
	}*/
	
	/**
	 * �޲ι��췽��
	 */
	public Person() {
		/*
		 * this()
		 * 		���ñ����е��޲ι��췽��
		 * this(ʵ��1,ʵ��2,ʵ��n...)
		 * 		���ñ����е��вι��췽��
		 * 
		 * �����������ֹ��췽��ʱ�����뱣֤д�ڹ��췽���еĵ�һ��
		 * */
		this("����",25);
		System.out.println("ʵ����Person�Ķ�������ִ���޲ι��췽��");
		
	}
	
	/**
	 * ��ʼ��Person�Ķ����ͬʱ��ΪPerson���������Ը�ֵ
	 * @param name
	 * @param age
	 */
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
}
