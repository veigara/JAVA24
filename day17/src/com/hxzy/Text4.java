package com.hxzy;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Text4 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入路径");
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
			System.out.println("文件名\t 是否是文件");
		asList.stream().forEach(i->System.out.println(i.getName()+"\t"+i.isFile()));
		}
	else {
		System.out.println("不存在改路径!");
	}
	
}
}