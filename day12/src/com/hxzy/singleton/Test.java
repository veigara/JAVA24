package com.hxzy.singleton;

public class Test {
	public static void main(String[] args) {
		/*Runtime.getRuntime().addShutdownHook(new Thread() {
			
			@Override
			public void run() {
				System.out.println("���������java������ر�");
			}
			
		});;*/
		//Singleton singleton = Singleton.getInstance();
		//Singleton singleton1 = Singleton.getInstance();
		//System.out.println(singleton);
		//System.out.println(singleton1);
		
		Runtime runtime = Runtime.getRuntime();
		System.out.println("CPU��������" + runtime.availableProcessors());
		//ϵͳ�ڴ�õ���ֵ��long������byte   1kb = 1024 byte      1mb = 1024kb   1gb = 1024m  1t = 1024g
		System.out.println("�����ڴ棺" + runtime.freeMemory() / 1024 / 1024 + "MB");
		
		System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");     //ϵͳ�����ռ�

		System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");   //ϵͳ�Ŀ��пռ�

		System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");   //��ǰ���õ��ܿռ�
	}
}
