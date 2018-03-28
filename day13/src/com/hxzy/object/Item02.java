package com.hxzy.object;

public class Item02 implements Cloneable{

	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();//ǳ��¡
		Item02 clone = (Item02) obj;
		clone.setName(new String(this.getName())); //���¡,ͨ����Ӧ���������ͽ������¡
		return clone;
	}
	
	public static void main(String[] args) {
		Item02 it1 = new Item02();
		it1.setName("alice");
		it1.setAge(3);
		try {
			Item02 clone = (Item02) it1.clone();
			System.out.println("�ڴ��ַ" + (it1 == clone));
			System.out.println("��¡��name��it1��name���бȽϣ�" + (it1.getName() == clone.getName()));
			System.out.println(clone.getName());
			System.out.println(clone.getAge());
			
			it1.setAge(10);//����it1��age
			it1.setName("����˿");
			System.out.println("�޸�it1��ֵ�Ժ�չʾclone�Ķ����ֵ�Ƿ����Ӱ��");
			System.out.println("it1�޸ĺ�����֣�" + it1.getName() + "��clone������"  +clone.getName());
			System.out.println("it1�޸ĺ�����䣺" + it1.getAge() + "��clone������"  +clone.getAge());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
}
