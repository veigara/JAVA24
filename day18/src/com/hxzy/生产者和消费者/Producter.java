package com.hxzy.�����ߺ�������;

/**
 * ������
 * @author Administrator
 *
 */
public class Producter implements Runnable{

	private Repository repository; //����ֿ�
	
	private String name;//����������
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Producter(Repository repository,String name) {
		super();
		this.repository = repository;
		this.name = name;
	}

	@Override
	public void run() {
		while (true) {
			try {
				repository.makeBread();
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
