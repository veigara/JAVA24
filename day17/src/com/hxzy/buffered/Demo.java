package com.hxzy.buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) {
		//read();
		write();
	}

	private static void read() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
			while (reader.ready()) {//只要有数据，则继续读下去
				String readLine = reader.readLine();//每次都一行
				System.out.println(readLine);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void write() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true));
			writer.newLine();//换行
			writer.write("第二十一届 2018年 俄罗斯 中国");
			writer.close();//关闭流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
