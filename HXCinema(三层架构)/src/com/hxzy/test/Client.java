package com.hxzy.test;

import java.util.List;
import java.util.Scanner;

import com.hxzy.biz.impl.FilmBizImpl;
import com.hxzy.entity.Film;

public class Client {
private static FilmBizImpl film =new FilmBizImpl();
	public static void main(String[] args) {
		System.out.println("��ӭ����*****ӰѶƽ̨");
		List<Film> query = film.query(1, 10);
		System.out.println("��ǰ��ӳ�ĵ�ӰΪ:");
		for (Film film : query) {
			System.out.println(film.getName());
		}
			
		System.out.println("��1ҳ,"+ "��"+(int) Math.ceil((double)film.total()/10)+"ҳ");
		
		System.out.println("��ѡ��1.���ݵ�Ӱ���Ʋ�ѯ��Ӱ��Ϣ  2.���ݵ�ӰԺ�鿴�õ�Ӱ������ӳ�ĵ�Ӱ");
		Scanner input=new Scanner(System.in);
		int choose=input.nextInt();
		if(choose==1) {
			System.out.println("�������Ӱ����");
			String name=input.next();
			Film fim = film.queryByName(name);
			System.out.println(fim.toString());
		}else {
			
		}
	}
		
}
