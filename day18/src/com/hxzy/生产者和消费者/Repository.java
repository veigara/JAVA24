package com.hxzy.生产者和消费者;

import java.util.List;
import java.util.Vector;

public class Repository {

	//共享的仓库，最多只能存100
	private List<Bread> list = new Vector<>();
	
	public final int CAPACITY = 10;//仓库容量上限为100
	
	/**
	 * 生产面包
	 * @throws Exception 
	 */
	public synchronized void makeBread() throws Exception {
		String name = Thread.currentThread().getName();//获取当前生产者的名字
		while (this.list.size() >= CAPACITY) { //如果生产的面包达到上限，则继续等待
			System.out.println("库存达到上限，"+name+"停止生产并等待消费");
			wait();
		}
		
		Bread bread = BreadList.getRandomBread();//获取随机的面包
		this.list.add(bread);
		
		System.out.println(name + "生产了一份" + bread.getType());
		
		notifyAll();//唤醒所有处于等待的线程
	}
	
	/**
	 * 消费，购买面包
	 * @throws InterruptedException 
	 */
	public synchronized void buy() throws InterruptedException {
		/*
		 * 程序第一次执行，假设消费者线程抢到资源，但是此时的集合中没有库存的面包
		 * 因此，消费者需要等待生产者生产面包
		 * */
		String name = Thread.currentThread().getName();
		while (this.list.size() <= 0) {
			System.out.println("当前库存不足，" + name + "等待生产");
			wait();//如果不足消费，则等待
		}
		Bread bread = this.list.remove(0);
		System.out.println(name + "消费了：" + bread.toString());
		
		notifyAll();//唤醒所有的线程（包括阻塞的线程）
	}
}
