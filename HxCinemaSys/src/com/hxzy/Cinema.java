package com.hxzy;

/**
 * ��ӰԺ����
 * ����������������ĳ����ӰԺ
 * Cinema wanDa = new Cinema();
 * Cinema UME = new Cinema();
 * @author Administrator
 *
 */
public class Cinema {
	private String name;//ӰԺ����
	private FilmList[] list;//��ǰ��ӰԺ������ӳ�ĵ�Ӱ��Ϣ
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public FilmList[] getList() {
		return list;
	}
	
	/**
	 * �������ĵ�ӰԺ��û����ӵ�Ӱ�ų���Ϣ������������飬����Ӹ��ų���Ϣ������0�±�
	 * 
	 * �������Ķ����Ѿ�����˵�Ӱ�ų���Ϣ����Ӧ�����ų���Ϣ�������׷���ų� 
	 * @param list ׷���ų���Ϣ
	 */
	public void setList(FilmList list) {
		if (this.list == null) {
			this.list = new FilmList[500]; //�������ĵ�ӰԺ��û����ӵ�Ӱ�ų���Ϣ������������飬����Ӹ��ų���Ϣ������0�±�
			this.list[0] = list;
			return;
		}
		
		/*
		 * �����һ��û�н���if��˵������Ķ����Ѿ�����˵�Ӱ�ų���Ϣ����Ӧ�����ų���Ϣ������׷���ų� 
		 */
		for (int i = 0; i < this.list.length; i++) {
			if (this.list[i] == null) {
				this.list[i] = list;
				return;
			}
		}
	}
	
	
}
