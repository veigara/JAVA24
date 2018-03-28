package com.hxzy.红绿灯;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

	public static void main(String[] args) {
		LightState state = new LightState();//共享资源
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		executor.execute(new RedLight(state));//红灯线程
		executor.execute(new GreenLight(state));//绿灯线程
		executor.execute(new YellowLight(state));//黄灯线程
		
		executor.shutdown();
	}

}
