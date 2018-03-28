package com.hxzy.singleton;

public class Test {
	public static void main(String[] args) {
		/*Runtime.getRuntime().addShutdownHook(new Thread() {
			
			@Override
			public void run() {
				System.out.println("程序结束，java虚拟机关闭");
			}
			
		});;*/
		//Singleton singleton = Singleton.getInstance();
		//Singleton singleton1 = Singleton.getInstance();
		//System.out.println(singleton);
		//System.out.println(singleton1);
		
		Runtime runtime = Runtime.getRuntime();
		System.out.println("CPU核心数：" + runtime.availableProcessors());
		//系统内存得到的值是long，代表byte   1kb = 1024 byte      1mb = 1024kb   1gb = 1024m  1t = 1024g
		System.out.println("空闲内存：" + runtime.freeMemory() / 1024 / 1024 + "MB");
		
		System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");     //系统的最大空间

		System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");   //系统的空闲空间

		System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");   //当前可用的总空间
	}
}
