package com.hxzy.dynProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GameProxy implements InvocationHandler {

	private Object obj; //被代理的对象
	
	/**
	 * 代理
	 * @param obj
	 * @return
	 */
	public Object blink(Object obj) {
		this.obj = obj;//被代理的对象
		//通过动态代理实例化对象
		/*
		 * Proxy.newProxyInstance();
		 * 参数1：被代理的类的类加载器
		 * 参数2：被代理对象实现的接口
		 * 
		 * 获取接口的目的：动态生成的代理对象实际上继承了Proxy并实现了参数2的接口
		 * */
		ClassLoader loader = obj.getClass().getClassLoader();
		Class<?>[] interfaces = obj.getClass().getInterfaces();
		return Proxy.newProxyInstance(loader, interfaces, this);//动态生成代理对象,$Proxy0,$Proxy1,$Proxy2
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/*通过反射执行被代理对象中的action方法*/
		System.out.println("-------通过代理连接台服-------");
		Object obj = method.invoke(this.obj, args);
		return obj;
	}

}
