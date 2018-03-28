package com.hxzy.output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件复制的操作
 * @author Administrator
 *
 */
public class CopyFileDemo {

	public static void main(String[] args) {
		//文件的源路径
		//目标路径
		String src = "F:\\java 24\\ES8.jpg";
		String dest = "F:\\java 24\\java\\ES8.jpg";
		
		try {
			FileInputStream in = new FileInputStream(src);//输入流
			FileOutputStream out = new FileOutputStream(dest);//输出流
			byte[] bytes = new byte[1024];
			while (in.read(bytes) != -1) {//这里负责读取
				out.write(bytes);//这里负责写出
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
