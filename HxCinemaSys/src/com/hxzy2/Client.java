package com.hxzy2;

import java.util.List;
import java.util.Scanner;

public class Client {

	private static Scanner input = new Scanner(System.in);
	private static CinemaBackManager m = new CinemaBackManager();
	//变量，变量的值可以任意改变
	//常量，常量声明时必须赋值，一旦赋值以后，就不能够更改常量的值
	//常量使用final修饰，并且常量名通常是大写
	private static final String SUCCESS = "操作成功!";
	private static final String FAIL = "操作失败!";
	private static final String REPEAT = "该信息已经存在，不能够重复操作！";
	
	
	public static void main(String[] args) {
		while (true) {
			System.out.println("1.添加热映电影");
			System.out.println("2.添加影院信息");
			System.out.println("3.为电影院添加电影的排场信息");
			System.out.println("4.根据电影院名称及电影名称查询该电影的场次信息");
			System.out.println("0.退出");
			System.out.println("请选择：");
			int choose = input.nextInt();
			switch (choose) {
			case 0:
				System.out.println("谢谢使用，再见！");
				return;
			case 1:
				addHotFilm();
				break;
			case 2:
				addCinema();
				break;
			case 3:
				addFilmList();
				break;
			case 4:
				getFilmByCinema();
				break;
			default:
				System.out.println("输入有误，请重新输入！");
				break;
			}
		}
	}

	/**
	 * 谁调用了我这个方法，谁就能够添加电影院
	 */
	public static void addCinema() {
		System.out.println("请输入电影院名称：");
		String cinemaName = input.next();
		Cinema cinema = m.getCinemaByName(cinemaName);
		if (cinema == null) {
			cinema = new Cinema();
			cinema.setName(cinemaName);
			int result = m.addCinema(cinema);
			System.out.println(result != -1 ? SUCCESS:FAIL);
		} else {
			System.out.println(REPEAT);
		}
	}
	
	/**
	 * 为电影院添加电影的排场信息
	 */
	public static void addFilmList() {
		System.out.println("请输入电影院名称：");
		String cinemaName = input.next();
		Cinema cinema = m.getCinemaByName(cinemaName);
		if (cinema == null) {
			System.out.println("输入的电影院名称有误！");
		} else {
			//指定添加的电影名称
			System.out.println("请输入要上映的电影名称");
			String filmName = input.next();
			Film film = m.getFilmByName(filmName);
			if (film != null) {
				//电影院根据自己的安排，来指定排场时间，放映厅，语言等信息
				System.out.println("请输入放映时间");
				String time = input.next();
				System.out.println("请输入语言种类");
				String language = input.next();
				System.out.println("请输入放映厅");
				String hourse = input.next();
				System.out.println("请输入价格");
				double price = input.nextDouble();
				
				//组建场次对象
				FilmItem filmItem = new FilmItem();
				filmItem.setTime(time);		
				filmItem.setLanguage(language);		
				filmItem.setHourse(hourse);	
				filmItem.setPrice(price);	
				
				FilmList filmList = new FilmList();
				filmList.setFilm(film);//播放的电影信息
				filmList.setList(filmItem);//该电影对应的播放场次信息
				
				cinema.setList(filmList);//为电影院添加正在播放的电影信息
				m.addFilmList(cinema,filmList);
			} else {
				System.out.println("输入的电影名称有误!");
			}
		}
	}
	
	/**
	 * 根据电影院名称及电影名称查询该电影的场次信息
	 */
	public static void getFilmByCinema() {
		System.out.println("请输入想要看的电影");
		String filmName = input.next();
		Film film = m.getFilmByName(filmName);
		if (film == null) {
			System.out.println("输入的电影信息有误！");
			return;
		}
		List<Cinema> cinemaByFilm = m.getCinemaByFilm(film);//根据电影院获取正在上映该电影的电影院的信息
		System.out.print("电影院名称：");
		for (int i = 0; i < cinemaByFilm.size(); i++) {
			Cinema cinema = cinemaByFilm.get(i);
			
			if (cinema == null) break;
			
			System.out.print(cinema.getName() + "\t");
		}
		System.out.println("请问需要查看哪家影院的排场信息?");
		String cinemaName = input.next();
		
		System.out.println("放映时间\t语言版本\t放映厅\t售价");
		for (int i = 0; i < cinemaByFilm.size(); i++) {
			Cinema cinema = cinemaByFilm.get(i);
			List<FilmList> list = cinema.getList();
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j) == null) break;
				if (cinema.getName().equals(cinemaName)) {
					FilmList filmList = list.get(j);
					if (filmList.getFilm() == film) {
						List<FilmItem> FilmItems = filmList.getList();
						for (int k = 0; k < FilmItems.size(); k++) {
							if (FilmItems.get(k) == null) break;
							FilmItem item = FilmItems.get(k);
							System.out.println(item.getTime() + "\t" + item.getLanguage() + "\t" + item.getHourse() + "\t" + item.getPrice());
						}
					}
				}
			}
		}
	}
	
	/**
	 * 添加正在热映的电影信息
	 */
	public static void addHotFilm() {
		System.out.println("请输入电影名称：");
		String filmName = input.next();
		System.out.println("请类型");
		String type = input.next();
		System.out.println("请输入发行地点");
		String location = input.next();
		System.out.println("请输入时长");
		int time = input.nextInt();
		System.out.println("请输入上映时间 格式（yyyy-MM-dd）");
		String date =input.next();
		System.out.println("请输入剧情简介");
		String info = input.next();
		
		Film film = new Film();
		film.setName(filmName);
		film.setType(type);
		film.setLocation(location);
		film.setTime(time);
		film.setDate(date);
		film.setInfo(info);
		
		int result = m.addFilm(film);
		System.out.println(result != -1 ? SUCCESS:FAIL);
		
	}
}
