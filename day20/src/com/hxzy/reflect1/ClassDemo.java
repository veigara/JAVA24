package com.hxzy.reflect1;

import java.util.Arrays;
import java.util.List;

import com.hxzy.bean.Student;

/**
 * ����Class������ȡ�����ַ�ʽ
 * @author Administrator
 *
 */
public class ClassDemo {
	
	private static final String PATH = "com.hxzy.bean.Student";

	public static void main(String[] args) throws Exception {
		//getClasses();
		
		Class<?> clas = getClassByPath(PATH);	//����·����ȡClass
		
		Object newInstance = newInstance(clas);//ͨ��clas����ʵ��
		
		//Student stu = new Student();
		
		System.out.println(newInstance instanceof Student);//�ж�һ�������Ƿ���ĳ�����ʵ��������boolean
		
		System.out.println("����������" + clas.getName());//����������·��
		System.out.println("������"  + clas.getSimpleName());
		System.out.println("����������" + clas.getSuperclass().getName());//Object�������·��
		
		Class<?>[] interfaces = clas.getInterfaces();
		List<Class<?>> list = Arrays.asList(interfaces);
		list.stream().forEach(i->{System.out.println(i.getName());});
		
		
	}

	/**
	 * ��ȡClass����ļ��ַ�ʽ
	 */
	private static void getClasses() {
		Class<Student> claz = Student.class;//��һ�ַ�ʽ
		
		Student stu = new Student();//ʵ����ѧ���Ķ���
		Class<? extends Student> cls2 = stu.getClass();  //�ڶ��ַ�ʽ
		
		//com.hxzy.bean.Student   ѧ���������·��
		try {
			Class<?> cls3 = Class.forName("com.hxzy.bean.Student");//�����ַ�ʽ
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ͨ���������·����ȡ�����Ӧ��Class
	 * @param path  �������·��
	 * @return Class��ʵ��
	 * @throws Exception 
	 */
	private static Class<?> getClassByPath(String path) throws Exception {
		return Class.forName(path);
	}
	
	/**
	 * ͨ��Class��ȡClass��������ʾ��
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private static Object newInstance(Class clas) throws Exception {
		//Object newInstance()  ����Class��������ʵ�����ʵ��
		return clas.newInstance();
	}

}
