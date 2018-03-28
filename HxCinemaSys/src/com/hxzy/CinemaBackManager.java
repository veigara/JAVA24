package com.hxzy;

/**
 * ӰѶƽ̨��̨����ϵͳ
 * ���ڹ����ҵ�ӰԺ
 * @author Administrator
 *
 */
public class CinemaBackManager {
	//��������еĵ�ӰԺ��
	private Cinema[] cinemas = new Cinema[500];
	private Film[] films = new Film[500];//��ǰ������ӳ�ĵ�Ӱ
	
	public CinemaBackManager() {
		Film film1 = new Film();
		film1.setName("��������");
		film1.setType("���顢����");
		film1.setTime(120);
		film1.setLocation("�й���½");
		film1.setDate("2018-01-01");
		film1.setInfo("һ�����˺�һ��Ů�˵Ĺ���");
		
		films[0] = film1;
		
		Film film2 = new Film();
		film2.setName("������Ϸ");
		film2.setType("���顢����");
		film2.setTime(119);
		film2.setLocation("����");
		film2.setDate("2018-01-05");
		film2.setInfo("�������˺�����Ů�˵Ĺ���");
		
		films[1] = film2;
		
		Cinema c1 = new Cinema();
		c1.setName("UME");
		
		FilmList filmList = new FilmList();
		filmList.setFilm(film1);
		
		FilmItem item = new FilmItem();
		item.setTime("9:45");
		item.setLanguage("����");
		item.setHourse("1����");
		item.setPrice(28.5);
		filmList.setList(item);
		
		c1.setList(filmList);
		cinemas[0] = c1;
		
		Cinema c2 = new Cinema();
		c2.setName("���Ӱ��");
		

		FilmList filmList2 = new FilmList();
		filmList2.setFilm(film1);
		
		FilmItem item2 = new FilmItem();
		item2.setTime("10:45");
		item2.setLanguage("����");
		item2.setHourse("ĵ����");
		item2.setPrice(28.5);
		filmList2.setList(item2);
		
		c2.setList(filmList2);
		cinemas[1] = c2;
		
	}
	
	/**
	 * ��ӵ�ӰԺ��Ϣ
	 * @param cinema ����̨�����齨�ĵ�ӰԺ��Ϣ
	 * @return -1 ���ʧ�ܣ����ڵ���0��˵����ӳɹ�
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
	 * ���ݵ�ӰԺ���Ʋ�ѯ��ӰԺ����Ϣ
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
	
	//2.�������ŵ�Ӱ
	//3.Ϊĳ����ӰԺ��ӵ�Ӱ���ų���Ϣ
	/**
	 * Ϊָ�����Ƶĵ�ӰԺ�����ӳ��Ӱ����Ϣ
	 * @param filmList
	 * @return -1 ���ʧ�ܣ����ڵ���0��˵����ӳɹ�
	 */
	public int addFilmList(Cinema cinema,FilmList filmList) {
		for (int i = 0; i < cinemas.length; i++) {
			if (cinemas[i] == cinema) { //�ж����ڵ�ַ������
				cinema.setList(filmList);
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * �����ӳ��Ӱ��Ϣ
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
	 * ���ݵ�Ӱ���Ʋ�ѯ��Ӱ��Ϣ
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
	//4.��ѯ��ǰ��ӳ�ĵ�Ӱ����ʾ���֣����ͣ���ӳʱ��
	//5.���ݵ�Ӱ������ʾ�õ�Ӱ��������Ϣ
	//6.����ӰԺ���ƣ���ѯ��ӰԺ������ӳ�ĵ�Ӱ
	
	/**
	 * ���ݵ�Ӱ����ȡ������ӳ�õ�Ӱ�ĵ�ӰԺ
	 * @param film
	 * @return
	 */
	public Cinema[] getCinemaByFilm(Film film) {
		Cinema[] c = new Cinema[500];
		int index = 0;
		for (int i = 0; i < cinemas.length; i++) {//���ѭ����ѭ�����е�ӰԺ
			if (cinemas[i] == null) break;
			//�ڲ�ѭ��������ÿ�ҵ�ӰԺ����ӳ�ĵ�Ӱ��Ϣ�࣬�жϸö����Ƿ����
			for (int j = 0; j < cinemas[i].getList().length; j++) {
				FilmList filmList = cinemas[i].getList()[j];
				if (filmList == null) {
					break;
				}
				if (filmList.getFilm() == film) { //�Ƚ��ڴ��ַ
					c[index++] = cinemas[i];
				}
			}
		}
		return c;
	}
}
