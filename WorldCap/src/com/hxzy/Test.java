package com.hxzy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) throws Exception {
		/*
		 * java中，java.io.File类的对象表示一个目录或文件
		 * */
	/*	File file = new File("data.txt");
		System.out.println(file.exists());*/
		
		/*
		 * File常用的方法
		 * 		判断File的对象是否存在    exists()
		 * 		创建目录
		 * 		创建文件
		 * 		删除文件或目录
		 * 		判断File是目录还是文件
		 * 如果需要读取File这个文件中的内容，应该用输入流来读取
		 * 		输入输出流已内存作为参照
		 * 		将文件中的数据读取到内存中称为输入流
		 * 		将内存中的数据写出到磁盘的文件中，成为输出流
		 * */
		
		Map<Integer, WorldCap> map = new HashMap<>();
		
		read(map);
		
		System.out.println("请输入一个年份");
		Scanner input = new Scanner(System.in);
		Integer t_year = input.nextInt();
		WorldCap worldCap = map.get(t_year);//通过键获取值
		if (worldCap != null) {
			System.out.println(worldCap.getYear() + "年，获得世界杯冠军的是：" + worldCap.getWinner());
		}else {
			System.out.println("该年份没有举办世界杯");
		}
		
		System.out.println("请输入一个国家");
		String country = input.next();
		/*for (Integer key : map.keySet()) {
			WorldCap worldCap2 = map.get(key);
			if (worldCap2.getWinner().equals(country)) {
				System.out.println(key + "、");
			}
		}*/
		
		map.values().stream().filter(i -> i.getWinner().equals(country)).forEach(i -> System.out.println(i.getYear() + "、"));
		
		input.close();
	}

	/**
	 * 从文件中读取数据
	 * @param map
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void read(Map<Integer, WorldCap> map) throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
		String str = null;
		while ((str = reader.readLine()) != null) {
			String[] split = str.split(" ");//第一届 1930年 乌拉圭 乌拉圭
			String js = split[0];
			String year_str = split[1];
			Integer year = Integer.valueOf(year_str.substring(0,year_str.length() - 1));
			String locate = split[2];
			String winner = split[3];
			
			map.put(year, new WorldCap(js, year, locate, winner));
		}
		reader.close();//关闭流
	}
	
}
