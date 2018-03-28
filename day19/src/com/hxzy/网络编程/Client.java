package com.hxzy.网络编程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception, IOException {
		Socket socket = new Socket("192.168.16.102", 9999);//创建客户端Socket
		//向服务端发送请求，因为服务端是被动（女的），客户端是主动的（男的）
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);//已字符输出流的方式输出文字信息
		pw.write("长江长江，我是黄河，我还是黄河！");
		pw.flush();//刷新缓存
		socket.shutdownOutput(); //关闭输出流
		
		InputStream in = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);//字符流和字节流的转换流
		BufferedReader reader = new BufferedReader(isr); //通过字符缓存流来读取文本
		
		StringBuilder sb = new StringBuilder();
		String str = null;
		while ((str = reader.readLine()) != null) { //每次读取一行数据
			sb.append(str);//拼接服务器返回的数据
		}
		System.out.println("服务端说：" + sb.toString());
		
		reader.close();
		isr.close();
		in.close();
		pw.close();
		os.close();
		socket.close();
	}

}
