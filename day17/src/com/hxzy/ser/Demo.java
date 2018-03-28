package com.hxzy.ser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		write();
		read();
	}

	private static void write() {
		Food f1 = new Food();
		f1.setName("苹果");
		f1.setPrice(5.5);
		
		Food f2 = new Food();
		f2.setName("香蕉");
		f2.setPrice(3.5);
		
		List<Food> list = new ArrayList<>();
		list.add(f1);
		list.add(f2);
		
		//name:苹果，价格：5.5
		try {
			File file = new File("F:\\java 24\\food.obj");
			if (!file.exists()) {
				file.createNewFile();
			}
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(list);//将Food的对象写入food.obj文件中
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void read() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:\\java 24\\food.obj"));
			List<Food> list =  (List<Food>) ois.readObject();
			ois.close();
			list.stream().forEach(System.out::println);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
