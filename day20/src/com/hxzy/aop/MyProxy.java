package com.hxzy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy<E,T extends E> implements InvocationHandler {

	private T obj;
	
	public E blink(T t) {//CalcDemo�Ķ���
		this.obj = t;
		ClassLoader loader = t.getClass().getClassLoader();
		Class<?>[] interfaces = t.getClass().getInterfaces();
		return (E) Proxy.newProxyInstance(loader, interfaces, this);//��̬���ɵĴ�������� $Proxy0
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("��ʼִ��" + method.getName() + "����");
		Object result = method.invoke(obj, args);
		System.out.println("���Ϊ��" + result);//���� aop
		return result;
	}

}
