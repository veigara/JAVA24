package com.hxzy.ºìÂÌµÆ;

public class RedLight implements Runnable{

	private LightState state;

	public RedLight(LightState state) {
		super();
		this.state = state;
	}

	@Override
	public void run() {
		while (true) {//ºìµÆĞèÒªÓÀÔ¶µÄÁÁÏÂÈ¥
			try {
				state.redLight();
			} catch (Exception e) {
				e.printStackTrace();
			}//ºìµÆÁÁ
		}
	}
	
	
	
}
