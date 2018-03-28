package com.hxzy.singleton;

/**
 * 国王类
 * @author Administrator
 *
 */
public class King {

	private String name;

	public King(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		King kangXi = new King("康熙");
		
		King qianLong = new King("乾隆");
		
		King shunZhi = new King("顺治");
		
		System.out.println(kangXi);
		System.out.println(qianLong);
		System.out.println(shunZhi);
		
	}
}
