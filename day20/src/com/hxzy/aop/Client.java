package com.hxzy.aop;

public class Client {

	public static void main(String[] args) {
		CalcDemo c = new CalcDemo();
	/*	int result = c.add(5, 10);
		System.out.println(result);//�ظ������
		
		int minus = c.minus(40, 20);
		System.out.println(minus);//�ظ������
*/		
		/*MyProxy<Calc, CalcDemo> proxy = new MyProxy<>();
		Calc calc = proxy.blink(c);//ͨ����̬����õ��������
		calc.add(5, 15);
		
		calc.minus(10, 5);*/
		func(5403210);
	}

	public static void func(int i){//54
		if(i > 0){
			int num = i % 10;//1 2 3 4
			i /= 10;//5
			System.out.print(num + " ");
			func(i);
		}
   }
}
