package com.hxzy.网络编程2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

	private static Socket socket;
	
	public static void main(String[] args) throws Exception, IOException {
		socket = new Socket("192.168.16.102", 8888);
		new MyClientReceiveThread(socket).start();//一个服务端对应多个客户端。一个客户端对应一个服务端
	}
	
	// 成员内部类，得到服务端下推的消息
	public static class MyClientReceiveThread extends Thread {
			private Socket client;

			public MyClientReceiveThread(Socket client) {
				this.client = client;
			}

			@Override
			public void run() {
				// 不断的读取服务器下推的消息
				DataInputStream dis;
				try {
					dis = new DataInputStream(client.getInputStream());
					while (true) {
						String msg = dis.readUTF();
						System.out.println("我是客户端，得到服务器下推的消息：" + msg);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

}
