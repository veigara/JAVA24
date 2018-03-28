package com.hxzy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Text5 {

	public static void main(String[] args) {
		File file =new File("E:\\log.txt");
		Scanner  input=new Scanner(System.in);
		String str=null;
		do { 
			System.out.println("ÇëÊäÈë×Ö·û´®");
			 str=input.next();
			if(str.equals("exit")) {
				return;
			}
			
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			FileOutputStream  out=new FileOutputStream(file,true);
			String str1=str+"\r\n";
			out.write(str1.getBytes());
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		} while (true);
		
	}

}
