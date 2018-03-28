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
			Object obj = clz.newInstance(); //�ȼ��� Demo demo = new Demo()  objΪ�յĶ���
			
			//���÷�װ������ֵ
			Method setName = clz.getDeclaredMethod("setName", String.class); //��ȡsetName��װ����
			setName.invoke(obj, "����"); //�ȼ���demo.setName("����");
			
			Method setAge = clz.getDeclaredMethod("setAge", int.class);
			setAge.invoke(obj, 18); //�ȼ���demo.setAge(18);
			
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
			
			BeanUtils.setProperty(obj, "name", "����");//setName
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
