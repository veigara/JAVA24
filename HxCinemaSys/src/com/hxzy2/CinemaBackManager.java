package com.hxzy2;

import java.util.ArrayList;
import java.util.List;

/**
 * 影讯平台后台管理系统
 * 用于管理多家电影院
 * @author Administrator
 *
 */
public class CinemaBackManager {
	//管理的所有的电影院，
	private List<Cinema> cinemaList = new ArrayList<>();
	private List<Film> filmList = new ArrayList<>();//当前正在热映的电影
	
	public CinemaBackManager() {
		Film film1 = new Film();
		film1.setName("无问西东");
		film1.setType("爱情、动作");
		film1.setTime(120);
		film1.setLocation("中国大陆");
		film1.setDate("2018-01-01");
		film1.setInfo("一个男人和一个女人的故事");
		
		filmList.add(film1);
		
		Film film2 = new Film();
		film2.setName("勇者游戏");
		film2.setType("爱情、动作");
		film2.setTime(119);
		film2.setLocation("美国");
		film2.setDate("2018-01-05");
		film2.setInfo("两个男人和两个女人的故事");
		
		filmList.add(film2);
		
		Cinema c1 = new Cinema();
		c1.setName("UME");
		
		FilmList filmList = new FilmList();
		filmList.setFilm(film1);
		
		FilmItem item = new FilmItem();
		item.setTime("9:45");
		item.setLanguage("中文");
		item.setHourse("1号厅");
		item.setPrice(28.5);
		filmList.setList(item);
		
		c1.setList(filmList);
		cinemaList.add(c1);
		
		Cinema c2 = new Cinema();
		c2.setName("万达影城");
		

		FilmList filmList2 = new FilmList();
		filmList2.setFilm(film1);
		
		FilmItem item2 = new FilmItem();
		item2.setTime("10:45");
		item2.setLanguage("中文");
		item2.setHourse("牡丹厅");
		item2.setPrice(28.5);
		filmList2.setList(item2);
		
		c2.setList(filmList2);
		cinemaList.add(c2);
		
	}
	
	/**
	 * 添加电影院信息
	 * @param cinema 控制台负责组建的电影院信息
	 * @return -1 添加失败，大于等于0则说明添加成功
	 */
	public int addCinema(Cinema cinema) {
		return cinemaList.add(cinema) ? 1 : -1;
	}
	
	/**
	 * 根据电影院名称查询电影院的信息
	 * @return
	 */
	public Cinema getCinemaByName(String cinemaName) {
		for (int i = 0; i < cinemaList.size(); i++) {
			Cinema cinema = cinemaList.get(i);
			if (cinema.getName().equals(cinemaName)) {
				return cinema;
			}
		}
		return null;
	}
	
	//2.新增热门电影
	//3.为某个电影院添加电影的排场信息
	/**
	 * 为指定名称的电影院添加上映电影的信息
	 * @param filmList
	 * @return -1 添加失败，大于等于0则说明添加成功
	 */
	public int addFilmList(Cinema cinema,FilmList filmList) {
		for (int i = 0; i < cinemaList.size(); i++) {
			 Cinema cinema2 = cinemaList.get(i);
			 if (cinema2.equals(cinema)) {
				 cinema2.setList(filmList);
				 return i;
			}
		}
		return -1;
	}
	
	/**
	 * 添加热映电影信息
	 * @param film
	 * @return
	 */
	public int addFilm(Film film) {
		
		return filmList.add(film) ? 1 : -1;
	}
	
	/**
	 * 根据电影名称查询电影信息
	 * @param filmName
	 * @return
	 */
	public Film getFilmByName(String filmName) {
		for (Film film : filmList) {
			if (film.getName().equals(filmName)) {
				return film;
			}
		}
		return null;
	}
	//4.查询当前上映的电影，显示名字，类型，上映时间
	//5.根据电影名称显示该电影的所有信息
	//6.根据影院名称，查询该影院正在上映的电影
	
	/**
	 * 根据电影来获取正在上映该电影的电影院
	 * @param film
	 * @return
	 */
	public List<Cinema> getCinemaByFilm(Film film) {
	
		List<Cinema> newList = new ArrayList<>();//存放正在上映该电影的电影院
		
		int index = 0;
		for (int i = 0; i < cinemaList.size(); i++) {//外层循环，循环所有电影院
			//内层循环，遍历每家电影院的上映的电影信息类，判断该对象是否存在
			Cinema cinema = cinemaList.get(i);
			for (int j = 0; j < cinema.getList().size(); j++) {
				FilmList filmList = cinema.getList().get(j);
				if (filmList == null) {
					break;
				}
				if (filmList.getFilm() == film) { //比较内存地址
					newList.add(cinema);
				}
			}
		}
		return newList;
	}
}
