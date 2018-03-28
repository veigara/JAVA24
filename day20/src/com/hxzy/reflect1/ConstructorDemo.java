package com.hxzy.reflect1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;

import com.hxzy.bean.Student;

public class ConstructorDemo {

	public static void main(String[] args) throws Exception {
		Class<?> cls = Class.forName("com.hxzy.bean.Student");//ͨ���������·����ȡClass
		/*Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();//Student�����ж��ٸ����캯�����ͻ�õ�����Ϊ���ٵĹ��캯��������
		for (Constructor<?> c : declaredConstructors) {
			System.out.println(c.toGenericString());//���������� Constructor ���ַ��������а������Ͳ�����
		}*/
		
		/*���ݲ����б��ȡ���캯��*/
		Constructor<?> c1 = cls.getDeclaredConstructor();//��ȡ�޲ι��캯��
		Constructor<?> c2 = cls.getDeclaredConstructor(String.class,int.class);//��ȡ�вι��캯��
		
		/*ͨ�����캯��ʵ��������*/
		Object obj1 = c1.newInstance();//ͨ���޲ι��캯��ʵ��������  Student stu = new Student();
		Object obj2 = c2.newInstance("����",28);//ͨ���вι��캯��ʵ�������� Student stu = new Student("����",28);
		
		System.out.println(obj1 instanceof Student);
		System.out.println(obj2 instanceof Student);
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		Class<?>[] parameterTypes1 = c1.getParameterTypes();//��ȡc1���캯���Ĳ����б������
		Class<?>[] parameterTypes2 = c2.getParameterTypes();//��ȡc2���캯���Ĳ����б������
		System.out.println("�вι��캯���Ĳ����б������");
		for (Class<?> class1 : parameterTypes2) {
			System.out.println(class1.getName());
		}
	}

}
