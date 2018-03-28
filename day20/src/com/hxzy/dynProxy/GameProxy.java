package com.hxzy.dynProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GameProxy implements InvocationHandler {

	private Object obj; //������Ķ���
	
	/**
	 * ����
	 * @param obj
	 * @return
	 */
	public Object blink(Object obj) {
		this.obj = obj;//������Ķ���
		//ͨ����̬����ʵ��������
		/*
		 * Proxy.newProxyInstance();
		 * ����1�������������������
		 * ����2�����������ʵ�ֵĽӿ�
		 * 
		 * ��ȡ�ӿڵ�Ŀ�ģ���̬���ɵĴ������ʵ���ϼ̳���Proxy��ʵ���˲���2�Ľӿ�
		 * */
		ClassLoader loader = obj.getClass().getClassLoader();
		Class<?>[] interfaces = obj.getClass().getInterfaces();
		return Proxy.newProxyInstance(loader, interfaces, this);//��̬���ɴ������,$Proxy0,$Proxy1,$Proxy2
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/*ͨ������ִ�б���������е�action����*/
		System.out.println("-------ͨ����������̨��-------");
		Object obj = method.invoke(this.obj, args);
		return obj;
	}

}
