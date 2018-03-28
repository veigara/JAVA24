package com.hxzy.网络编程2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

/**
 * 服务端的示例代码
 * 
 * @author Administrator
 *
 */
public class Server {

	private static Vector<ClientThread> list = new Vector<>();

	private static ServerSocket server;

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// 创建ServerSocket，服务端，并绑定接口
		server = new ServerSocket(8888);

		new Thread(new ServerThread()).start();

	}

	public static class ServerThread implements Runnable {

		@Override
		public void run() {
			while (true) {
				try {
					Socket socket = server.accept();
					ClientThread client = new ClientThread(socket);// 存放客户端Socket的线程
					client.start();
					list.add(client);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 多线程实现Socket，因为多人聊天，每个人都是一个Socket。因此必须用多线程实现网路通信
	 * 
	 * @author Administrator
	 *
	 */
	public static class ClientThread extends Thread {

		private Socket socket;// 每个一个客户端

		public ClientThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			synchronized (this) {
				for (int i = 0; i < 10; i++) {
					//每次循环，推送消息
					for (ClientThread mc : list) {
						System.out.println("-----------------");
						mc.serverSend(i + "");
					}
				}

			}
		}

		/**
		 * 服务端往下推的方法
		 * 
		 * @param msg
		 */
		public void serverSend(String msg) {
			try {
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				dos.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		};

	}
}
