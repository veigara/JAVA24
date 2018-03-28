package com.hxzy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Text1 {

	public static void main(String[] args) {
		File file =new File("E:\\lx1.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			FileOutputStream   out=new FileOutputStream(file,true);
			String st="Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，是由Sun Microsystems公司于\r\n" + 
					"1995年5月推出的Java程序设计语言和Java平台（即JavaSE, JavaEE, JavaME）的总称。Java 技术具有\r\n" + 
					"卓越的通用性、高效性、平台移植性和安全性，广泛应用于个人PC、数据中心、游戏控制台、科学超级\r\n" + 
					"计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。在全球云计算和移动互联网的产业\r\n" + 
					"环境下，Java更具备了显著优势和广阔前景。";
			byte[] bytes = st.getBytes();
			out.write(bytes);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		
		}

	}

}
