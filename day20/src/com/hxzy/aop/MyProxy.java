package com.hxzy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy<E,T extends E> implements InvocationHandler {

	private T obj;
	
	public E blink(T t) {//CalcDemo的对象
		this.obj = t;
		ClassLoader loader = t.getClass().getClassLoader();
		Class<?>[] interfaces = t.getClass().getInterfaces();
		return (E) Proxy.newProxyInstance(loader, interfaces, this);//动态生成的代理类对象 $Proxy0
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("开始执行" + method.getName() + "方法");
		Object result = method.invoke(obj, args);
		System.out.println("结果为：" + result);//切面 aop
		return result;
	}

}
