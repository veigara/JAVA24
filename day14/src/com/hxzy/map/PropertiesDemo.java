package com.hxzy.map;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) {
		Properties prop = new Properties();
	
		InputStream resourceAsStream = PropertiesDemo.class.getResourceAsStream("/test.properties");
		try {
			prop.load(resourceAsStream);	//�����ļ�
			String encode = prop.getProperty("encode");//ͨ��properties�ļ��еļ���ȡֵ
			System.out.println(encode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
