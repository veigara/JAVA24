package com.hxzy.readerAndWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) {
		//read();
		write();
	}

	public static void write() {
		try {
			FileWriter writer = new FileWriter("data.txt", true);
			String content = "\r\n�ڶ�ʮһ�� 2018�� ����˹ �й�";
			//writer.write(content);
			
			char[] charArray = content.toCharArray();
			int i = 0;
			while (i < charArray.length) {
				writer.write(charArray[i]);
				i++;
			}
			
			writer.close();//�ر���
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void read() {
		try {
			FileReader reader = new FileReader("data.txt");
			StringBuilder sb = new StringBuilder();
			char[] cs = new char[1024];
			while (reader.ready()) {
				//char c = (char) reader.read();		//ÿ�ζ�һ���ַ�
				//sb.append(c);
				reader.read(cs);
				String str = new String(cs);			//ÿ�ζ�ȡһ��ָ�������ַ�����
				sb.append(str);
			}
			reader.close();
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
