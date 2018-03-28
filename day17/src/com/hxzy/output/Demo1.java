package com.hxzy.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo1 {

	public static void main(String[] args) {
		
		writer("\r\njava 24班");//\r\n在windows中代表回车并换行
	}

	/**
	 * FileOutputStream(String pathname)		如果文件存在内容，则覆盖
	 * FileOutputStream(String pathname,boolean append)，如果append为true，则实现文件末尾追加
	 * FileOutputStream(File file)
	 * FileOutputStream(File file,boolean append)	向文件末尾追加内容
	 * @param content
	 */
	private static void writer(String content) {
		try {
			File f = new File("F:\\java 24\\1.txt");
			if (!f.exists()) {
				f.createNewFile();//如果这个地址不存在文件，则创建
			}
			FileOutputStream os = new FileOutputStream(f,true);
			byte[] bytes = content.getBytes();//将字符串转换成为byte[]
			int i = 0;
			while (i < bytes.length) {
				os.write(bytes[i]);//每次写一个字节
				i++;
			}
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void writer2(String content) {
		try {
			File f = new File("F:\\java 24\\1.txt");
			if (!f.exists()) {
				f.createNewFile();//如果这个地址不存在文件，则创建
			}
			FileOutputStream os = new FileOutputStream(f,true);
			byte[] bytes = content.getBytes();//将字符串转换成为byte[]
			os.write(bytes);//直接将字符串数组写到文件中
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
