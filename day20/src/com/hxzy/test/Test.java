package com.hxzy.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Test {

	public static void main(String[] args) throws Exception {
		//test1();
		//test2();
		test3();
	}

	private static void test1() throws IOException {
		Properties prop = new Properties();
		//通过类加载器获取资源，返回java.io.InputStream的对象
		prop.load(Test.class.getClassLoader().getResourceAsStream("com/hxzy/test/init.properties"));
		String userName = prop.getProperty("username");
		System.out.println(userName);
	}

	private static void test2() throws Exception {
		Properties prop = new Properties();
		prop.load(Test.class.getResourceAsStream("/com/hxzy/test/init.properties"));//  第一个/代表根目录 
		String userName = prop.getProperty("username");
		System.out.println(userName);
	}
	
	private static void test3() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("init_2.properties"));//获取项目根目录下的文件
		String userName = prop.getProperty("username");
		System.out.println(userName);
	}
}
