package com.hxzy.reflect1;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.hxzy.bean.Student;

/**
 * 通过反射获取类中的属性
 * @author Administrator
 *
 */
public class FieldDemo {

	private static final String PATH = "com.hxzy.bean.Student";
	
	public static void main(String[] args) throws Exception {
		Class<?> clas = getClassByPath(PATH); //通过路径获取Class
		//创建stu_clas的实例
		Object obj = clas.newInstance();//空的学生对象，Student stu = new Student();
		
		/*
		 * 为stu这个空的对象赋值
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
	 * 用户为clas指定的属性赋值
	 * @param name
	 * @param value
	 * @param clas
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	private static void set(String name,Object value,Object obj) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class<? extends Object> clas = obj.getClass();//获取obj对象对应的Class
		Field declaredField = clas.getDeclaredField(name);//通过属性名获取Field
		int modifiers = declaredField.getModifiers();//以整数形式返回由此 Field 对象表示的字段的 Java 语言修饰符。
		if (modifiers == Modifier.PRIVATE) { //判断该属性是否为私有的
			declaredField.setAccessible(true);//将私有属性设置为可见
		}
		declaredField.set(obj, value);
	}
	
	
	/**
	 * 通过类的完整路径获取该类对应的Class
	 * @param path  类的完整路径
	 * @return Class的实例
	 * @throws Exception 
	 */
	private static Class<?> getClassByPath(String path) throws Exception {
		return Class.forName(path);
	}
	
	/**
	 * Field中的方法
	 * @param clas
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	private static void readField(Class<?> clas) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Student stu = new Student();//创建的student的实例
		
		//通过反射获取stu中属性的值
		Class<? extends Student> clas_stu = stu.getClass();
		Field[] fields1 = clas_stu.getFields(); //通过Class的getFields方法获取clas_stu代表的类的属性.返回公共的字段
		
		System.out.println("获取公共的字段");
		for (Field field : fields1) {
			System.out.println(field.getName());
		}
		System.out.println();
		System.out.println("获取所有字段");
		Field[] fields2 = clas_stu.getDeclaredFields();//获取Class的getFields方法获取clas_stu中的所有字段
		for (Field field : fields2) {
			System.out.println(field.getName());
		}
		
		//通过Class对象获取对象的属性
		Field f_name = clas_stu.getDeclaredField("name");//Class类中的方法，代表根据属性名获取该属性对应的Field
		Field f_age = clas_stu.getDeclaredField("age");
		
		/*
		 * 通过反射为私有的属性赋值需要先设置属性的可见性
		 * */
		f_name.setAccessible(true);
		f_name.set(stu, "test1");
		
		f_age.setAccessible(true);
		f_age.set(stu, 18);
		
		/*
		 * 通过反射获取对象的值
		 * */
		Object v_name = f_name.get(stu);//获取stu对象中f_name表示的name属性的值
		Object v_age = f_age.get(stu); //获取stu对象中f_age表示的年龄的值
		System.out.println("姓名：" + v_name + ",年龄：" + v_age);
		//System.out.println(stu);
		
	}
}
