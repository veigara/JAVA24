package com.hxzy.��·��Ʊ����2_ͬ������;

/**
 * ��Ʊ�Ķ��󣬶��߳�
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
			ticket.sell();//ֻҪ����Ʊ���������Ʊ
		}
	}

}
