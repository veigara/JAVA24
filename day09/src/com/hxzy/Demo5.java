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
		
		v = second(v);//��second�����ڲ���val���ڴ��ַ������main�����е�v���ڴ��ַ   0x2233
		System.out.println(v.i);
	}

	public void second(Value v, int i) { //v:0x1234
		i = 0;
		v.i = 20;
		Value val = new Value(); //val:0x2233
		v = val; //�ֲ�����v���ڴ��ַ���0x2233
		System.out.println(v.i + " " + i);
	}
	
	public Value second(Value v) { //v:0x1234
		v.i = 20;
		Value val = new Value(); //val:0x2233
		v = val; //�ֲ�����v���ڴ��ַ���0x2233
		System.out.println(v.i);
		return v;
	}
}
