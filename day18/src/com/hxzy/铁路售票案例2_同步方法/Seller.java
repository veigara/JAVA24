package com.hxzy.铁路售票案例2_同步方法;

/**
 * 售票的对象，多线程
 * @author Administrator
 *
 */
public class Seller implements Runnable {

	private Ticket ticket;
	
	public Seller(Ticket ticket) {
		super();
		this.ticket = ticket;
	}
	
	@Override
	public void run() {
		while (ticket.getTicket() > 0) {
			ticket.sell();//只要有余票，则继续售票
		}
	}

}
