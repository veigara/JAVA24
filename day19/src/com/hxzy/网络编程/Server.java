package com.hxzy.������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����˵�ʾ������
 * @author Administrator
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		//����ServerSocket������ˣ����󶨽ӿ�
		ServerSocket server = new ServerSocket(9999);
		Socket socket = server.accept();//�ȴ�����˷�������
		InputStream in = socket.getInputStream(); //�ֽ�������
		InputStreamReader isr = new InputStreamReader(in); //�ֽ������ַ������м���
		BufferedReader reader = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		String str = null;
		while ((str = reader.readLine()) != null) { //ÿ�ζ�ȡһ������
			sb.append(str); //ƴ�ӿͻ��˷��͵���Ϣ
		}
		System.out.println("�ͻ���˵��" + sb.toString()); //����ͻ��˷��͵���Ϣ
		
		//����Ϣ�ӷ���˴��ݸ��ͻ���
		OutputStream os = socket.getOutputStream();//�ֽ������
		PrintWriter pw = new PrintWriter(os);
		pw.write("�ƺӻƺӣ����ǳ��������ǳ�����");  //������������ͻ���
		pw.flush(); //ˢ�»���
		
		/*�ر���Դ���ͷ�����*/
		reader.close();
		isr.close();
		in.close();
		
		pw.close();
		os.close();
		socket.close();
		server.close();
	}

}
