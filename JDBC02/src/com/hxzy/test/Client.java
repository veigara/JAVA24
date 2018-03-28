package com.hxzy.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;

public class Client {

	public static void main(String[] args) {
		/*Demo demo = new Demo();
		demo.setName("");
		demo.setAge(11);
		
		System.out.println(demo);*/
		
		/*try {
			Class<?> clz = Class.forName("com.hxzy.test.Demo");
			Object obj = clz.newInstance(); //等价于 Demo demo = new Demo()  obj为空的对象
			
			//调用封装方法赋值
			Method setName = clz.getDeclaredMethod("setName", String.class); //获取setName封装方法
			setName.invoke(obj, "张三"); //等价于demo.setName("张三");
			
			Method setAge = clz.getDeclaredMethod("setAge", int.class);
			setAge.invoke(obj, 18); //等价于demo.setAge(18);
			
			System.out.println(obj);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}*/
		
		try {
			Class<?> clz = Class.forName("com.hxzy.test.Demo");
			Object obj = clz.newInstance();
			
			BeanUtils.setProperty(obj, "name", "张三");//setName
			BeanUtils.setProperty(obj, "age", 18);//setName
			BeanUtils.setProperty(obj, "date", new Date());
			System.out.println(obj);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
