package com.hxzy.铁路售票案例2_同步方法;

/**
 * 共享资源类
 * @author Administrator
 *
 */
public class Ticket {
	private int ticket = 20;
	
	public int getTicket() {
		return ticket;
	}

	public synchronized void sell() {
		if (ticket <= 0) {
			System.out.println("无余票可售");
			return;
		}
		String name = Thread.currentThread().getName();
		System.out.println(name + "售出一张票,票号：" + ticket--);
		/*try {
			Thread.sleep(100);//模拟购票时间，因为买票不是马上就完成的
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}
}
