package com.hxzy.���̵�;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

	public static void main(String[] args) {
		LightState state = new LightState();//������Դ
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		executor.execute(new RedLight(state));//����߳�
		executor.execute(new GreenLight(state));//�̵��߳�
		executor.execute(new YellowLight(state));//�Ƶ��߳�
		
		executor.shutdown();
	}

}
