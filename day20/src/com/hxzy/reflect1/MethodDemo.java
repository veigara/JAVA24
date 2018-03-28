package com.hxzy.reflect1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import com.hxzy.bean.Student;

public class MethodDemo {

	public static void main(String[] args) throws Exception {
		//invoke();
		readMethod();
	}
	
	private static void readMethod() {
		Class<?> clas = Student.class;
		//获取clas中所有的方法
		Method[] declaredMethods = clas.getDeclaredMethods();//获取所有的方法
		System.out.println("----------getDeclaredMethods----------");
		for (Method m : declaredMethods) {
			String m_name = m.getName();
			System.out.println("方法名:" + m_name);
			Class<?>[] parameterTypes = m.getParameterTypes();//获取m方法的参数列表的类型
			System.out.println("参数列表的类型名：");
			for (Class<?> class1 : parameterTypes) {
				System.out.print(class1.getName() + ",");
			}
			System.out.println();
			Type genericReturnType = m.getGenericReturnType();//获取m方法的返回值类型
			System.out.println("返回值类型为：" + genericReturnType.getTypeName());

			Class<?> returnType = m.getReturnType();
			System.out.println("返回值类型：" + returnType.getName());
			m.getExceptionTypes();//返回该方法抛出的异常
			
			int modifier = m.getModifiers();//返回方法的访问修饰符的类型
			System.out.println("访问修饰符类型：" + Modifier.toString(modifier));
			
			
			System.out.println("============================================================");
		}
		
		/*System.out.println("----------getMethods----------");
		Method[] methods = clas.getMethods();//获取公共的方法，包括父类中公共的方法
		for (Method m : methods) {
			System.out.println(m.getName());
		}*/
	}

	private static void invoke() throws Exception {
		Class<?> clas = Student.class;
		
		Object obj = clas.newInstance();//一个空的Student的对象,Student stu = new Student();
		
		/*
		 * 根据方法名及参数列表获取方法
		 * 第一个参数：方法名
		 * 第二个参数：参数列表，可变长度数组
		 * */
		Method setName = clas.getDeclaredMethod("setName", String.class);
		
		/*执行该方法
		 * 第一个参数：要执行哪个对象的setName方法
		 * 第二个参数：实参的参数列表
		 * */
		setName.invoke(obj, "张三");//stu.setName("张三");
		
		/*通过反射调用方法获取返回值*/
		
		Method getName = clas.getDeclaredMethod("getName");
		Object name = getName.invoke(obj);
		System.out.println(name);
	}
}
