package com.hxzy.ºìÂÌµÆ;

public class YellowLight implements Runnable {
	private LightState state;

	public YellowLight(LightState state) {
		super();
		this.state = state;
	}

	@Override
	public void run() {
		while (true) {//»ÆµÆĞèÒªÓÀÔ¶µÄÁÁÏÂÈ¥
			try {
				state.yellow();
			} catch (Exception e) {
				e.printStackTrace();
			}//»ÆµÆÁÁ
		}
	}
	
}
