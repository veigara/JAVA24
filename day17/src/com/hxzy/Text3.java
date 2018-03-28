package com.hxzy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Text3 {

	public static void main(String[] args) {
		String sr="E:\\lx1.txt";
		String newsr="E:\\lx\\lx1.txt";
		try {
			FileInputStream input=new FileInputStream(sr);
			FileOutputStream out=new FileOutputStream(newsr);
			byte[] arr=new byte[1024];
			int i=0;
			while((i=input.read(arr))!=-1) {
				out.write(arr);
			}
			input.close();
			out.close();
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}

	}

}
