package com.hxzy.���̵�;

public class GreenLight implements Runnable{
	private LightState state;

	public GreenLight(LightState state) {
		super();
		this.state = state;
	}

	@Override
	public void run() {
		while (true) {//�̵���Ҫ��Զ������ȥ
			try {
				state.greenLight();
			} catch (Exception e) {
				e.printStackTrace();
			}//�̵���
		}
	}
	
	
}
