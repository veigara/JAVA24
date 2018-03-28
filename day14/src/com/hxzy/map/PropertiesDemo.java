package com.hxzy.map;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) {
		Properties prop = new Properties();
	
		InputStream resourceAsStream = PropertiesDemo.class.getResourceAsStream("/test.properties");
		try {
			prop.load(resourceAsStream);	//加载文件
			String encode = prop.getProperty("encode");//通过properties文件中的键获取值
			System.out.println(encode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
