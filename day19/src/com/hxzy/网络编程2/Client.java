package com.hxzy.������2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

	private static Socket socket;
	
	public static void main(String[] args) throws Exception, IOException {
		socket = new Socket("192.168.16.102", 8888);
		new MyClientReceiveThread(socket).start();//һ������˶�Ӧ����ͻ��ˡ�һ���ͻ��˶�Ӧһ�������
	}
	
	// ��Ա�ڲ��࣬�õ���������Ƶ���Ϣ
	public static class MyClientReceiveThread extends Thread {
			private Socket client;

			public MyClientReceiveThread(Socket client) {
				this.client = client;
			}

			@Override
			public void run() {
				// ���ϵĶ�ȡ���������Ƶ���Ϣ
				DataInputStream dis;
				try {
					dis = new DataInputStream(client.getInputStream());
					while (true) {
						String msg = dis.readUTF();
						System.out.println("���ǿͻ��ˣ��õ����������Ƶ���Ϣ��" + msg);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

}
