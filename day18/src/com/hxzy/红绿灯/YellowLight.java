package com.hxzy.���̵�;

public class YellowLight implements Runnable {
	private LightState state;

	public YellowLight(LightState state) {
		super();
		this.state = state;
	}

	@Override
	public void run() {
		while (true) {//�Ƶ���Ҫ��Զ������ȥ
			try {
				state.yellow();
			} catch (Exception e) {
				e.printStackTrace();
			}//�Ƶ���
		}
	}
	
}
