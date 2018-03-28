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
		//��ȡclas�����еķ���
		Method[] declaredMethods = clas.getDeclaredMethods();//��ȡ���еķ���
		System.out.println("----------getDeclaredMethods----------");
		for (Method m : declaredMethods) {
			String m_name = m.getName();
			System.out.println("������:" + m_name);
			Class<?>[] parameterTypes = m.getParameterTypes();//��ȡm�����Ĳ����б������
			System.out.println("�����б����������");
			for (Class<?> class1 : parameterTypes) {
				System.out.print(class1.getName() + ",");
			}
			System.out.println();
			Type genericReturnType = m.getGenericReturnType();//��ȡm�����ķ���ֵ����
			System.out.println("����ֵ����Ϊ��" + genericReturnType.getTypeName());

			Class<?> returnType = m.getReturnType();
			System.out.println("����ֵ���ͣ�" + returnType.getName());
			m.getExceptionTypes();//���ظ÷����׳����쳣
			
			int modifier = m.getModifiers();//���ط����ķ������η�������
			System.out.println("�������η����ͣ�" + Modifier.toString(modifier));
			
			
			System.out.println("============================================================");
		}
		
		/*System.out.println("----------getMethods----------");
		Method[] methods = clas.getMethods();//��ȡ�����ķ��������������й����ķ���
		for (Method m : methods) {
			System.out.println(m.getName());
		}*/
	}

	private static void invoke() throws Exception {
		Class<?> clas = Student.class;
		
		Object obj = clas.newInstance();//һ���յ�Student�Ķ���,Student stu = new Student();
		
		/*
		 * ���ݷ������������б��ȡ����
		 * ��һ��������������
		 * �ڶ��������������б��ɱ䳤������
		 * */
		Method setName = clas.getDeclaredMethod("setName", String.class);
		
		/*ִ�и÷���
		 * ��һ��������Ҫִ���ĸ������setName����
		 * �ڶ���������ʵ�εĲ����б�
		 * */
		setName.invoke(obj, "����");//stu.setName("����");
		
		/*ͨ��������÷�����ȡ����ֵ*/
		
		Method getName = clas.getDeclaredMethod("getName");
		Object name = getName.invoke(obj);
		System.out.println(name);
	}
}
