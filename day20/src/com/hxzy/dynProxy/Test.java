package com.hxzy.dynProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.hxzy.staticProxy.Game;
import com.hxzy.staticProxy.Player;

public class Test {

	private static Player p = new Player();//������Ķ���
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> proxyClass = Proxy.getProxyClass(p.getClass().getClassLoader(), p.getClass().getInterfaces());
		System.out.println(proxyClass.getName()); //��̬�������ɵĴ�����Ķ���
		/*Constructor<?>[] declaredConstructors = proxyClass.getDeclaredConstructors();
		for (Constructor<?> c : declaredConstructors) {
			System.out.println("���캯����" + c.getName());
			Class<?>[] parameterTypes = c.getParameterTypes();
			for (Class<?> c1 : parameterTypes) {
				System.out.print(c1.getName() + ",");
			}
		}*/
		Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);//��ȡ$Proxy0���еĹ��캯��
		/*
		 * ��̬���ɵ�$Proxy0�̳���Proxyʵ����Game�ӿ�
		 * 
		 * */
		Game game = (Game) constructor.newInstance(new MyProxy());
		System.out.println("�ж�game�Ƿ�ΪProxy���������:" + (game instanceof Proxy));
		game.lvlUp();
	}

	
	public static class MyProxy implements InvocationHandler{

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			//objΪ������Ķ���
			return method.invoke(p, args);
		}
		
	}
}
