package com.hxzy;

/**
 * 影讯平台后台管理系统
 * 用于管理多家电影院
 * @author Administrator
 *
 */
public class CinemaBackManager {
	//管理的所有的电影院，
	private Cinema[] cinemas = new Cinema[500];
	private Film[] films = new Film[500];//当前正在热映的电影
	
	public CinemaBackManager() {
		Film film1 = new Film();
		film1.setName("无问西东");
		film1.setType("爱情、动作");
		film1.setTime(120);
		film1.setLocation("中国大陆");
		film1.setDate("2018-01-01");
		film1.setInfo("一个男人和一个女人的故事");
		
		films[0] = film1;
		
		Film film2 = new Film();
		film2.setName("勇者游戏");
		film2.setType("爱情、动作");
		film2.setTime(119);
		film2.setLocation("美国");
		film2.setDate("2018-01-05");
		film2.setInfo("两个男人和两个女人的故事");
		
		films[1] = film2;
		
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
		cinemas[0] = c1;
		
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
		cinemas[1] = c2;
		
	}
	
	/**
	 * 添加电影院信息
	 * @param cinema 控制台负责组建的电影院信息
	 * @return -1 添加失败，大于等于0则说明添加成功
	 */
	public int addCinema(Cinema cinema) {
		for (int i = 0; i < cinemas.length; i++) {
			if (cinemas[i] == null) {
				cinemas[i] = cinema;
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 根据电影院名称查询电影院的信息
	 * @return
	 */
	public Cinema getCinemaByName(String cinemaName) {
		for (int i = 0; i < cinemas.length; i++) {
			if (cinemas[i] == null) {
				 return null;
			}
			if (cinemas[i].getName().equals(cinemaName)) {
				return cinemas[i];
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
		for (int i = 0; i < cinemas.length; i++) {
			if (cinemas[i] == cinema) { //判断是内地址，引用
				cinema.setList(filmList);
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
		for (int i = 0; i < films.length; i++) {
			if (films[i] == null) {
				films[i] = film;
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 根据电影名称查询电影信息
	 * @param filmName
	 * @return
	 */
	public Film getFilmByName(String filmName) {
		for (int i = 0; i < films.length; i++) {
			if (films[i] == null) {
				 return null;
			}
			if (films[i].getName().equals(filmName)) {
				return films[i];
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
	public Cinema[] getCinemaByFilm(Film film) {
		Cinema[] c = new Cinema[500];
		int index = 0;
		for (int i = 0; i < cinemas.length; i++) {//外层循环，循环所有电影院
			if (cinemas[i] == null) break;
			//内层循环，遍历每家电影院的上映的电影信息类，判断该对象是否存在
			for (int j = 0; j < cinemas[i].getList().length; j++) {
				FilmList filmList = cinemas[i].getList()[j];
				if (filmList == null) {
					break;
				}
				if (filmList.getFilm() == film) { //比较内存地址
					c[index++] = cinemas[i];
				}
			}
		}
		return c;
	}
}
