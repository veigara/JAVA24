package com.hxzy2;

import java.util.List;
import java.util.Scanner;

public class Client {

	private static Scanner input = new Scanner(System.in);
	private static CinemaBackManager m = new CinemaBackManager();
	//������������ֵ��������ı�
	//��������������ʱ���븳ֵ��һ����ֵ�Ժ󣬾Ͳ��ܹ����ĳ�����ֵ
	//����ʹ��final���Σ����ҳ�����ͨ���Ǵ�д
	private static final String SUCCESS = "�����ɹ�!";
	private static final String FAIL = "����ʧ��!";
	private static final String REPEAT = "����Ϣ�Ѿ����ڣ����ܹ��ظ�������";
	
	
	public static void main(String[] args) {
		while (true) {
			System.out.println("1.�����ӳ��Ӱ");
			System.out.println("2.���ӰԺ��Ϣ");
			System.out.println("3.Ϊ��ӰԺ��ӵ�Ӱ���ų���Ϣ");
			System.out.println("4.���ݵ�ӰԺ���Ƽ���Ӱ���Ʋ�ѯ�õ�Ӱ�ĳ�����Ϣ");
			System.out.println("0.�˳�");
			System.out.println("��ѡ��");
			int choose = input.nextInt();
			switch (choose) {
			case 0:
				System.out.println("ллʹ�ã��ټ���");
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
				System.out.println("�����������������룡");
				break;
			}
		}
	}

	/**
	 * ˭�����������������˭���ܹ���ӵ�ӰԺ
	 */
	public static void addCinema() {
		System.out.println("�������ӰԺ���ƣ�");
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
	 * Ϊ��ӰԺ��ӵ�Ӱ���ų���Ϣ
	 */
	public static void addFilmList() {
		System.out.println("�������ӰԺ���ƣ�");
		String cinemaName = input.next();
		Cinema cinema = m.getCinemaByName(cinemaName);
		if (cinema == null) {
			System.out.println("����ĵ�ӰԺ��������");
		} else {
			//ָ����ӵĵ�Ӱ����
			System.out.println("������Ҫ��ӳ�ĵ�Ӱ����");
			String filmName = input.next();
			Film film = m.getFilmByName(filmName);
			if (film != null) {
				//��ӰԺ�����Լ��İ��ţ���ָ���ų�ʱ�䣬��ӳ�������Ե���Ϣ
				System.out.println("�������ӳʱ��");
				String time = input.next();
				System.out.println("��������������");
				String language = input.next();
				System.out.println("�������ӳ��");
				String hourse = input.next();
				System.out.println("������۸�");
				double price = input.nextDouble();
				
				//�齨���ζ���
				FilmItem filmItem = new FilmItem();
				filmItem.setTime(time);		
				filmItem.setLanguage(language);		
				filmItem.setHourse(hourse);	
				filmItem.setPrice(price);	
				
				FilmList filmList = new FilmList();
				filmList.setFilm(film);//���ŵĵ�Ӱ��Ϣ
				filmList.setList(filmItem);//�õ�Ӱ��Ӧ�Ĳ��ų�����Ϣ
				
				cinema.setList(filmList);//Ϊ��ӰԺ������ڲ��ŵĵ�Ӱ��Ϣ
				m.addFilmList(cinema,filmList);
			} else {
				System.out.println("����ĵ�Ӱ��������!");
			}
		}
	}
	
	/**
	 * ���ݵ�ӰԺ���Ƽ���Ӱ���Ʋ�ѯ�õ�Ӱ�ĳ�����Ϣ
	 */
	public static void getFilmByCinema() {
		System.out.println("��������Ҫ���ĵ�Ӱ");
		String filmName = input.next();
		Film film = m.getFilmByName(filmName);
		if (film == null) {
			System.out.println("����ĵ�Ӱ��Ϣ����");
			return;
		}
		List<Cinema> cinemaByFilm = m.getCinemaByFilm(film);//���ݵ�ӰԺ��ȡ������ӳ�õ�Ӱ�ĵ�ӰԺ����Ϣ
		System.out.print("��ӰԺ���ƣ�");
		for (int i = 0; i < cinemaByFilm.size(); i++) {
			Cinema cinema = cinemaByFilm.get(i);
			
			if (cinema == null) break;
			
			System.out.print(cinema.getName() + "\t");
		}
		System.out.println("������Ҫ�鿴�ļ�ӰԺ���ų���Ϣ?");
		String cinemaName = input.next();
		
		System.out.println("��ӳʱ��\t���԰汾\t��ӳ��\t�ۼ�");
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
	 * ���������ӳ�ĵ�Ӱ��Ϣ
	 */
	public static void addHotFilm() {
		System.out.println("�������Ӱ���ƣ�");
		String filmName = input.next();
		System.out.println("������");
		String type = input.next();
		System.out.println("�����뷢�еص�");
		String location = input.next();
		System.out.println("������ʱ��");
		int time = input.nextInt();
		System.out.println("��������ӳʱ�� ��ʽ��yyyy-MM-dd��");
		String date =input.next();
		System.out.println("�����������");
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
