package com.hxzy.reflect1;

import java.util.Arrays;
import java.util.List;

import com.hxzy.bean.Student;

/**
 * 反射Class类对象获取的三种方式
 * @author Administrator
 *
 */
public class ClassDemo {
	
	private static final String PATH = "com.hxzy.bean.Student";

	public static void main(String[] args) throws Exception {
		//getClasses();
		
		Class<?> clas = getClassByPath(PATH);	//根据路径获取Class
		
		Object newInstance = newInstance(clas);//通过clas创建实例
		
		//Student stu = new Student();
		
		System.out.println(newInstance instanceof Student);//判断一个对象是否是某个类的实例，返回boolean
		
		System.out.println("完整类名：" + clas.getName());//类名的完整路径
		System.out.println("类名："  + clas.getSimpleName());
		System.out.println("父类类名：" + clas.getSuperclass().getName());//Object类的完整路径
		
		Class<?>[] interfaces = clas.getInterfaces();
		List<Class<?>> list = Arrays.asList(interfaces);
		list.stream().forEach(i->{System.out.println(i.getName());});
		
		
	}

	/**
	 * 获取Class对象的几种方式
	 */
	private static void getClasses() {
		Class<Student> claz = Student.class;//第一种方式
		
		Student stu = new Student();//实例化学生的对象
		Class<? extends Student> cls2 = stu.getClass();  //第二种方式
		
		//com.hxzy.bean.Student   学生类的完整路径
		try {
			Class<?> cls3 = Class.forName("com.hxzy.bean.Student");//第三种方式
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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
	 * 通过Class获取Class代表的类的示例
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private static Object newInstance(Class clas) throws Exception {
		//Object newInstance()  创建Class对象代表的实体类的实例
		return clas.newInstance();
	}

}
