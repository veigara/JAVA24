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
	 * ÿ�ζ�ȡһ���ֽ�
	 */
	private static void read() {
		FileInputStream fs = null;
		try {
			fs = new FileInputStream("data.txt");
			int i = 0;
			StringBuilder sb = new StringBuilder();
			while ( (i = fs.read()) != -1) { //ÿ�ζ�ȡһ���ֽ�
				char c = (char) i;
				sb.append(c);
			}
			fs.close();//�ر���
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ÿ�ζ�ȡһ��byte[]
	 */
	private static void readByteArray1() {
		try {
			FileInputStream fs = new FileInputStream("data.txt");
			byte[] bytes = new byte[1024];//ÿ�ζ�ȡһ��1024�����ֽ�
			//System.out.println(fs.available());//���Զ�ȡ���ֽ��������Ƽ�ʹ��
			
			//read(byte[]);���ص��Ƕ�ȡ�ֽڵĸ���
			int i = 0;
			while ( (i = fs.read(bytes)) != -1) {
				//System.out.println(i);
				String str = new String(bytes);
				System.out.println(str);
			}
			fs.close();//�ر���
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
			//System.out.println(fs.available());//���Զ�ȡ���ֽ��������Ƽ�ʹ��
			
			
			/*fs.read(bytes, off, len)
			*	ÿ�ζ�ȡָ�����ȵ�����
			*	off,ÿ�ζ�ȡʱ��ƫ����
			*	len,ÿ�ζ�ȡ����
			*/
			
			//read(byte[]);���ص��Ƕ�ȡ�ֽڵĸ���
			int len = 0;
			while ( (len = fs.read(bytes)) != -1) {
				String str = new String(bytes, 0, len);
				System.out.println(str);
			}
			fs.close();//�ر���
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
