package com.hxzy;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Text4 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("������·��");
		String pathname=input.next();
		input.close();
		dir(pathname);
		
	}
	/**
	 * 
	 * @param pathname
	 */
	private static void dir(String pathname) {
		File file =new File(pathname);
		if(file.exists()) {
			File[] listFiles = file.listFiles();
			List<File> asList = Arrays.asList(listFiles);
			System.out.println("�ļ���\t �Ƿ����ļ�");
		asList.stream().forEach(i->System.out.println(i.getName()+"\t"+i.isFile()));
		}
	else {
		System.out.println("�����ڸ�·��!");
	}
	
}
}