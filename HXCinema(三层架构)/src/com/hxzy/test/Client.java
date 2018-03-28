package com.hxzy.test;

import java.util.List;
import java.util.Scanner;

import com.hxzy.biz.impl.FilmBizImpl;
import com.hxzy.entity.Film;

public class Client {
private static FilmBizImpl film =new FilmBizImpl();
	public static void main(String[] args) {
		System.out.println("欢迎来到*****影讯平台");
		List<Film> query = film.query(1, 10);
		System.out.println("当前热映的电影为:");
		for (Film film : query) {
			System.out.println(film.getName());
		}
			
		System.out.println("第1页,"+ "共"+(int) Math.ceil((double)film.total()/10)+"页");
		
		System.out.println("请选择1.根据电影名称查询电影信息  2.根据电影院查看该电影正在上映的电影");
		Scanner input=new Scanner(System.in);
		int choose=input.nextInt();
		if(choose==1) {
			System.out.println("请输入电影名称");
			String name=input.next();
			Film fim = film.queryByName(name);
			System.out.println(fim.toString());
		}else {
			
		}
	}
		
}
