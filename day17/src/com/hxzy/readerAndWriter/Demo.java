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
			String content = "\r\n第二十一届 2018年 俄罗斯 中国";
			//writer.write(content);
			
			char[] charArray = content.toCharArray();
			int i = 0;
			while (i < charArray.length) {
				writer.write(charArray[i]);
				i++;
			}
			
			writer.close();//关闭流
			
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
				//char c = (char) reader.read();		//每次读一个字符
				//sb.append(c);
				reader.read(cs);
				String str = new String(cs);			//每次读取一个指定长度字符数组
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
