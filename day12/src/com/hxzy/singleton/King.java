package com.hxzy.singleton;

/**
 * ������
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
		King kangXi = new King("����");
		
		King qianLong = new King("Ǭ¡");
		
		King shunZhi = new King("˳��");
		
		System.out.println(kangXi);
		System.out.println(qianLong);
		System.out.println(shunZhi);
		
	}
}
