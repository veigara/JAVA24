package com.hxzy;

class Demo5 {
	public static void main(String argv[]) {
		Demo5 t = new Demo5();
		t.first();
	}

	public void first() {
		int i = 5;
		Value v = new Value();//0x1234
		v.i = 25;
		//second(v, i);
		//System.out.println(v.i);
		
		v = second(v);//用second方法内部的val的内存地址覆盖了main方法中的v的内存地址   0x2233
		System.out.println(v.i);
	}

	public void second(Value v, int i) { //v:0x1234
		i = 0;
		v.i = 20;
		Value val = new Value(); //val:0x2233
		v = val; //局部变量v的内存地址变成0x2233
		System.out.println(v.i + " " + i);
	}
	
	public Value second(Value v) { //v:0x1234
		v.i = 20;
		Value val = new Value(); //val:0x2233
		v = val; //局部变量v的内存地址变成0x2233
		System.out.println(v.i);
		return v;
	}
}
