package com.hxzy.������2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

/**
 * ����˵�ʾ������
 * 
 * @author Administrator
 *
 */
public class Server {

	private static Vector<ClientThread> list = new Vector<>();

	private static ServerSocket server;

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// ����ServerSocket������ˣ����󶨽ӿ�
		server = new ServerSocket(8888);

		new Thread(new ServerThread()).start();

	}

	public static class ServerThread implements Runnable {

		@Override
		public void run() {
			while (true) {
				try {
					Socket socket = server.accept();
					ClientThread client = new ClientThread(socket);// ��ſͻ���Socket���߳�
					client.start();
					list.add(client);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * ���߳�ʵ��Socket����Ϊ�������죬ÿ���˶���һ��Socket����˱����ö��߳�ʵ����·ͨ��
	 * 
	 * @author Administrator
	 *
	 */
	public static class ClientThread extends Thread {

		private Socket socket;// ÿ��һ���ͻ���

		public ClientThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			synchronized (this) {
				for (int i = 0; i < 10; i++) {
					//ÿ��ѭ����������Ϣ
					for (ClientThread mc : list) {
						System.out.println("-----------------");
						mc.serverSend(i + "");
					}
				}

			}
		}

		/**
		 * ����������Ƶķ���
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
