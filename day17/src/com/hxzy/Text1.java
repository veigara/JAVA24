package com.hxzy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Text1 {

	public static void main(String[] args) {
		File file =new File("E:\\lx1.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			FileOutputStream   out=new FileOutputStream(file,true);
			String st="Java��һ�ֿ���׫д��ƽ̨Ӧ��������������ĳ���������ԣ�����Sun Microsystems��˾��\r\n" + 
					"1995��5���Ƴ���Java����������Ժ�Javaƽ̨����JavaSE, JavaEE, JavaME�����ܳơ�Java ��������\r\n" + 
					"׿Խ��ͨ���ԡ���Ч�ԡ�ƽ̨��ֲ�ԺͰ�ȫ�ԣ��㷺Ӧ���ڸ���PC���������ġ���Ϸ����̨����ѧ����\r\n" + 
					"��������ƶ��绰�ͻ�������ͬʱӵ��ȫ�����Ŀ�����רҵ��Ⱥ����ȫ���Ƽ�����ƶ��������Ĳ�ҵ\r\n" + 
					"�����£�Java���߱����������ƺ͹���ǰ����";
			byte[] bytes = st.getBytes();
			out.write(bytes);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		
		}

	}

}
