package com.hxzy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Text2 {

	public static void main(String[] args) {
		
				
			try {
				FileInputStream in=new FileInputStream("E:\\lx1.txt");
				byte [] arr=new byte[1024];
				int i=0;
				while((i=in.read(arr))!=-1) {
					String str=new String(arr);
					System.out.println(str);
					}
					
				in.close();
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] arr=new byte[1024];
		
		
		
}
}
