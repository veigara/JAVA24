package com.hxzy.生产者和消费者;

/**
 * 生产者
 * @author Administrator
 *
 */
public class Producter implements Runnable{

	private Repository repository; //共享仓库
	
	private String name;//生产者名字
	
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
