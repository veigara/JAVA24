package com.hxzy.dynProxy;

public class RealSubject implements Subject {

	/**
	 * ��̨������Ϸ��ֱ��
	 */
	
	@Override
	public void action() {
		System.out.println("����̨��������Ϸ");
	}

}
