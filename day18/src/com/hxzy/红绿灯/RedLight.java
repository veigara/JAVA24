package com.hxzy.���̵�;

public class RedLight implements Runnable{

	private LightState state;

	public RedLight(LightState state) {
		super();
		this.state = state;
	}

	@Override
	public void run() {
		while (true) {//�����Ҫ��Զ������ȥ
			try {
				state.redLight();
			} catch (Exception e) {
				e.printStackTrace();
			}//�����
		}
	}
	
	
	
}
