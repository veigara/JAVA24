package com.hxzy.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {

	public static void main(String[] args) {
		//read();
		//readByteArray1();
		//readByteArray2();
	}
	
	/**
	 * 每次读取一个字节
	 */
	private static void read() {
		FileInputStream fs = null;
		try {
			fs = new FileInputStream("data.txt");
			int i = 0;
			StringBuilder sb = new StringBuilder();
			while ( (i = fs.read()) != -1) { //每次读取一个字节
				char c = (char) i;
				sb.append(c);
			}
			fs.close();//关闭流
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 每次读取一个byte[]
	 */
	private static void readByteArray1() {
		try {
			FileInputStream fs = new FileInputStream("data.txt");
			byte[] bytes = new byte[1024];//每次读取一个1024长度字节
			//System.out.println(fs.available());//可以读取的字节数，不推荐使用
			
			//read(byte[]);返回的是读取字节的个数
			int i = 0;
			while ( (i = fs.read(bytes)) != -1) {
				//System.out.println(i);
				String str = new String(bytes);
				System.out.println(str);
			}
			fs.close();//关闭流
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void readByteArray2() {
		try {
			FileInputStream fs = new FileInputStream("data.txt");
			byte[] bytes = new byte[1024];
			//System.out.println(fs.available());//可以读取的字节数，不推荐使用
			
			
			/*fs.read(bytes, off, len)
			*	每次读取指定长度的数组
			*	off,每次读取时的偏移量
			*	len,每次读取多少
			*/
			
			//read(byte[]);返回的是读取字节的个数
			int len = 0;
			while ( (len = fs.read(bytes)) != -1) {
				String str = new String(bytes, 0, len);
				System.out.println(str);
			}
			fs.close();//关闭流
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
