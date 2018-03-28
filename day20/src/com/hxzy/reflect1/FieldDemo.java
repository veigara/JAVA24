package com.hxzy.reflect1;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.hxzy.bean.Student;

/**
 * ͨ�������ȡ���е�����
 * @author Administrator
 *
 */
public class FieldDemo {

	private static final String PATH = "com.hxzy.bean.Student";
	
	public static void main(String[] args) throws Exception {
		Class<?> clas = getClassByPath(PATH); //ͨ��·����ȡClass
		//����stu_clas��ʵ��
		Object obj = clas.newInstance();//�յ�ѧ������Student stu = new Student();
		
		/*
		 * Ϊstu����յĶ���ֵ
		 * */
		set("name", "test1",obj);
		set("age", 18, obj);
		
		//System.out.println(obj);
		Field[] declaredFields = clas.getDeclaredFields();
		for (Field field : declaredFields) {
			if (field.getModifiers() == 26) {//11010
				continue;
			}
			if (Modifier.isPrivate(field.getModifiers())) {
				field.setAccessible(true);
			}
			System.out.println(field.get(obj));
		}
	}
	
	/**
	 * �û�Ϊclasָ�������Ը�ֵ
	 * @param name
	 * @param value
	 * @param clas
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	private static void set(String name,Object value,Object obj) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class<? extends Object> clas = obj.getClass();//��ȡobj�����Ӧ��Class
		Field declaredField = clas.getDeclaredField(name);//ͨ����������ȡField
		int modifiers = declaredField.getModifiers();//��������ʽ�����ɴ� Field �����ʾ���ֶε� Java �������η���
		if (modifiers == Modifier.PRIVATE) { //�жϸ������Ƿ�Ϊ˽�е�
			declaredField.setAccessible(true);//��˽����������Ϊ�ɼ�
		}
		declaredField.set(obj, value);
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
	 * Field�еķ���
	 * @param clas
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	private static void readField(Class<?> clas) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Student stu = new Student();//������student��ʵ��
		
		//ͨ�������ȡstu�����Ե�ֵ
		Class<? extends Student> clas_stu = stu.getClass();
		Field[] fields1 = clas_stu.getFields(); //ͨ��Class��getFields������ȡclas_stu������������.���ع������ֶ�
		
		System.out.println("��ȡ�������ֶ�");
		for (Field field : fields1) {
			System.out.println(field.getName());
		}
		System.out.println();
		System.out.println("��ȡ�����ֶ�");
		Field[] fields2 = clas_stu.getDeclaredFields();//��ȡClass��getFields������ȡclas_stu�е������ֶ�
		for (Field field : fields2) {
			System.out.println(field.getName());
		}
		
		//ͨ��Class�����ȡ���������
		Field f_name = clas_stu.getDeclaredField("name");//Class���еķ��������������������ȡ�����Զ�Ӧ��Field
		Field f_age = clas_stu.getDeclaredField("age");
		
		/*
		 * ͨ������Ϊ˽�е����Ը�ֵ��Ҫ���������ԵĿɼ���
		 * */
		f_name.setAccessible(true);
		f_name.set(stu, "test1");
		
		f_age.setAccessible(true);
		f_age.set(stu, 18);
		
		/*
		 * ͨ�������ȡ�����ֵ
		 * */
		Object v_name = f_name.get(stu);//��ȡstu������f_name��ʾ��name���Ե�ֵ
		Object v_age = f_age.get(stu); //��ȡstu������f_age��ʾ�������ֵ
		System.out.println("������" + v_name + ",���䣺" + v_age);
		//System.out.println(stu);
		
	}
}
