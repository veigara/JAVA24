package com.hxzy.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo1 {

	public static void main(String[] args) {
		
		writer("\r\njava 24��");//\r\n��windows�д���س�������
	}

	/**
	 * FileOutputStream(String pathname)		����ļ��������ݣ��򸲸�
	 * FileOutputStream(String pathname,boolean append)�����appendΪtrue����ʵ���ļ�ĩβ׷��
	 * FileOutputStream(File file)
	 * FileOutputStream(File file,boolean append)	���ļ�ĩβ׷������
	 * @param content
	 */
	private static void writer(String content) {
		try {
			File f = new File("F:\\java 24\\1.txt");
			if (!f.exists()) {
				f.createNewFile();//��������ַ�������ļ����򴴽�
			}
			FileOutputStream os = new FileOutputStream(f,true);
			byte[] bytes = content.getBytes();//���ַ���ת����Ϊbyte[]
			int i = 0;
			while (i < bytes.length) {
				os.write(bytes[i]);//ÿ��дһ���ֽ�
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
				f.createNewFile();//��������ַ�������ļ����򴴽�
			}
			FileOutputStream os = new FileOutputStream(f,true);
			byte[] bytes = content.getBytes();//���ַ���ת����Ϊbyte[]
			os.write(bytes);//ֱ�ӽ��ַ�������д���ļ���
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
