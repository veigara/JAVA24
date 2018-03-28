package com.hxzy.exception;

/**
 * 自定义除数为0的异常
 * @author Administrator
 *
 */
public class DivisorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DivisorException() {
		super("除数不能为0！");
	}
	
}
