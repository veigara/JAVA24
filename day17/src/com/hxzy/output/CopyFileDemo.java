package com.hxzy.output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �ļ����ƵĲ���
 * @author Administrator
 *
 */
public class CopyFileDemo {

	public static void main(String[] args) {
		//�ļ���Դ·��
		//Ŀ��·��
		String src = "F:\\java 24\\ES8.jpg";
		String dest = "F:\\java 24\\java\\ES8.jpg";
		
		try {
			FileInputStream in = new FileInputStream(src);//������
			FileOutputStream out = new FileOutputStream(dest);//�����
			byte[] bytes = new byte[1024];
			while (in.read(bytes) != -1) {//���︺���ȡ
				out.write(bytes);//���︺��д��
			}
			in.close();
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
