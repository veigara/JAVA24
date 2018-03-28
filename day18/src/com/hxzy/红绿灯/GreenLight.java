package com.hxzy.ºìÂÌµÆ;

public class GreenLight implements Runnable{
	private LightState state;

	public GreenLight(LightState state) {
		super();
		this.state = state;
	}

	@Override
	public void run() {
		while (true) {//ÂÌµÆĞèÒªÓÀÔ¶µÄÁÁÏÂÈ¥
			try {
				state.greenLight();
			} catch (Exception e) {
				e.printStackTrace();
			}//ÂÌµÆÁÁ
		}
	}
	
	
}
