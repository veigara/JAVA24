package com.hxzy.网络编程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端的示例代码
 * @author Administrator
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		//创建ServerSocket，服务端，并绑定接口
		ServerSocket server = new ServerSocket(9999);
		Socket socket = server.accept();//等待服务端发送请求
		InputStream in = socket.getInputStream(); //字节输入流
		InputStreamReader isr = new InputStreamReader(in); //字节流和字符流的中间人
		BufferedReader reader = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		String str = null;
		while ((str = reader.readLine()) != null) { //每次读取一行数据
			sb.append(str); //拼接客户端发送的信息
		}
		System.out.println("客户端说：" + sb.toString()); //输出客户端发送的信息
		
		//将信息从服务端传递给客户端
		OutputStream os = socket.getOutputStream();//字节输出流
		PrintWriter pw = new PrintWriter(os);
		pw.write("黄河黄河，我是长江，我是长江！");  //将数据输出给客户端
		pw.flush(); //刷新缓存
		
		/*关闭资源，释放连接*/
		reader.close();
		isr.close();
		in.close();
		
		pw.close();
		os.close();
		socket.close();
		server.close();
	}

}
