package com.hxzy.生产者和消费者;

public class Customer implements Runnable {

	private Repository repository;
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer(Repository repository,String name) {
		super();
		this.repository = repository;
		this.name = name;
	}

	@Override
	public void run() {
		while (true) {
			try {
				this.repository.buy();
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
