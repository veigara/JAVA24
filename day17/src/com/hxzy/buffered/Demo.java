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
			while (reader.ready()) {//ֻҪ�����ݣ����������ȥ
				String readLine = reader.readLine();//ÿ�ζ�һ��
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
			writer.newLine();//����
			writer.write("�ڶ�ʮһ�� 2018�� ����˹ �й�");
			writer.close();//�ر���
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
