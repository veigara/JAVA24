package com.hxzy.interfacedemo;

/**
 * ����һ������Ĺ�����
 * �߱�����������������
 * @author Administrator
 *
 */
public class Worker extends Person implements DriverInterface,CookerInterface{

	public void test() {
		System.out.println("test");
	}
	
	@Override
	public void cook() {
		System.out.println(super.getName() + "������");
	}

	@Override
	public void drive() {
		System.out.println(super.getName() + "�Ὺ��");
	}

	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.setName("����");
		worker.cook();
		worker.drive();
	}
}
