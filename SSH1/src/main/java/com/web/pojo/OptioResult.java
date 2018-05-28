package com.web.pojo;

public class OptioResult {

	private boolean flag; //true:操作成功   false:操作失败
	private String message;//提示信息
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
