package com.hxzy.reflect1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;

import com.hxzy.bean.Student;

public class ConstructorDemo {

	public static void main(String[] args) throws Exception {
		Class<?> cls = Class.forName("com.hxzy.bean.Student");//通过类的完整路径获取Class
		/*Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();//Student类中有多少个构造函数，就会得到长度为多少的构造函数的数组
		for (Constructor<?> c : declaredConstructors) {
			System.out.println(c.toGenericString());//返回描述此 Constructor 的字符串，其中包括类型参数。
		}*/
		
		/*根据参数列表获取构造函数*/
		Constructor<?> c1 = cls.getDeclaredConstructor();//获取无参构造函数
		Constructor<?> c2 = cls.getDeclaredConstructor(String.class,int.class);//获取有参构造函数
		
		/*通过构造函数实例化对象*/
		Object obj1 = c1.newInstance();//通过无参构造函数实例化对象  Student stu = new Student();
		Object obj2 = c2.newInstance("张三",28);//通过有参构造函数实例化对象 Student stu = new Student("张三",28);
		
		System.out.println(obj1 instanceof Student);
		System.out.println(obj2 instanceof Student);
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		Class<?>[] parameterTypes1 = c1.getParameterTypes();//获取c1构造函数的参数列表的类型
		Class<?>[] parameterTypes2 = c2.getParameterTypes();//获取c2构造函数的参数列表的类型
		System.out.println("有参构造函数的参数列表的类型");
		for (Class<?> class1 : parameterTypes2) {
			System.out.println(class1.getName());
		}
	}

}
