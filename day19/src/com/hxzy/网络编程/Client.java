package com.hxzy.������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception, IOException {
		Socket socket = new Socket("192.168.16.102", 9999);//�����ͻ���Socket
		//�����˷���������Ϊ������Ǳ�����Ů�ģ����ͻ����������ģ��еģ�
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);//���ַ�������ķ�ʽ���������Ϣ
		pw.write("�������������ǻƺӣ��һ��ǻƺӣ�");
		pw.flush();//ˢ�»���
		socket.shutdownOutput(); //�ر������
		
		InputStream in = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);//�ַ������ֽ�����ת����
		BufferedReader reader = new BufferedReader(isr); //ͨ���ַ�����������ȡ�ı�
		
		StringBuilder sb = new StringBuilder();
		String str = null;
		while ((str = reader.readLine()) != null) { //ÿ�ζ�ȡһ������
			sb.append(str);//ƴ�ӷ��������ص�����
		}
		System.out.println("�����˵��" + sb.toString());
		
		reader.close();
		isr.close();
		in.close();
		pw.close();
		os.close();
		socket.close();
	}

}
