package com.hxzy.红绿灯;

/**
 * 管理红黄绿三个灯的状态的类
 * @author Administrator
 *
 */
public class LightState {
	//状态，描述当前正在亮的灯的状态,默认红灯（1：红灯  2：绿灯  3：黄灯）
	private Integer state = 1;
	
	/**
	 * 红灯亮
	 * @throws Exception 
	 */
	public void redLight() throws Exception {
		synchronized (this) {
			while (state != 1) { //如果当前状态不为1，则说明其他颜色的灯在亮，因此红灯线程需要等待
				wait();
			}
			for (int i = 0; i < 5; i++) {
				System.out.println("红灯亮" + (i + 1) + "下");
				Thread.sleep(1000);
			}
			state = 2;//灯状态的改变
			
			notifyAll();//唤醒其他等待的线程
		}
	}
	
	/**
	 * 绿灯亮
	 * @throws Exception 
	 */
	public void greenLight() throws Exception {
		synchronized (this) {
			while (state != 2) { //如果当前状态不为1，则说明其他颜色的灯在亮，因此绿灯线程需要等待
				wait();
			}
			for (int i = 0; i < 5; i++) {
				System.out.println("绿灯亮" + (i + 1) + "下");
				Thread.sleep(1000);
			}
			state = 3;//灯状态的改变
			
			notifyAll();//唤醒其他等待的线程
		}
	}
	
	/**
	 * 黄灯亮
	 * @throws Exception 
	 */
	public void yellow() throws Exception {
		synchronized (this) {
			while (state != 3) { //如果当前状态不为1，则说明其他颜色的灯在亮，因此黄灯线程需要等待
				wait();
			}
			for (int i = 0; i < 3; i++) {
				System.out.println("黄灯亮" + (i + 1) + "下");
				Thread.sleep(1000);
			}
			state = 1;//灯状态的改变
			
			notifyAll();//唤醒其他等待的线程
		}
	}
}
