package com.hxzy.dynProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.hxzy.staticProxy.Game;
import com.hxzy.staticProxy.Player;

public class Test {

	private static Player p = new Player();//被代理的对象
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> proxyClass = Proxy.getProxyClass(p.getClass().getClassLoader(), p.getClass().getInterfaces());
		System.out.println(proxyClass.getName()); //动态代理生成的代理类的对象
		/*Constructor<?>[] declaredConstructors = proxyClass.getDeclaredConstructors();
		for (Constructor<?> c : declaredConstructors) {
			System.out.println("构造函数：" + c.getName());
			Class<?>[] parameterTypes = c.getParameterTypes();
			for (Class<?> c1 : parameterTypes) {
				System.out.print(c1.getName() + ",");
			}
		}*/
		Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);//获取$Proxy0类中的构造函数
		/*
		 * 动态生成的$Proxy0继承了Proxy实现了Game接口
		 * 
		 * */
		Game game = (Game) constructor.newInstance(new MyProxy());
		System.out.println("判断game是否为Proxy的子类对象:" + (game instanceof Proxy));
		game.lvlUp();
	}

	
	public static class MyProxy implements InvocationHandler{

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			//obj为被代理的对象
			return method.invoke(p, args);
		}
		
	}
}
