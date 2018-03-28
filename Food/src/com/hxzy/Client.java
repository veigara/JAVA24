package com.hxzy;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		System.out.println("��ӭʹ��XXXʳƷ����ϵͳ");
		Scanner input = new Scanner(System.in);
		FoodManager fm = new FoodManager();//����ʳƷ������
				
		int choose;
		Food food;
		int result;
		String foodName;
		double foodPrice;
		do {
			System.out.println("��ѡ��");
			System.out.println("1.���ʳƷ��Ϣ");
			System.out.println("2.����ʳƷ���ƣ���ѯʳƷ��Ϣ");
			System.out.println("3.����ʳƷ���ƣ��޸�ʳƷ�۸�");
			System.out.println("4.��������ʳƷ�ܼ�");
			System.out.println("5.ͳ������ʳƷ��������Ʒ��Ϣ");
			System.out.println("6.����ʳƷ�ļ۸��������������ЩʳƷ����Ϣ");
			System.out.println("7.�˳�");
			choose = input.nextInt();//�����û�������
			switch (choose) {
				case 1:
					System.out.println("������ʳƷ����");
					foodName = input.next();
					
					//ͨ��ʳƷ������֤ʳƷ�Ƿ��Ѿ�����
					food = fm.getFoodByName(foodName);
					if (food != null) {//foodΪnull��˵�����鲻���ڸ����ֵ�ʳƷ
						System.out.println("��ʳƷ�Ѵ��ڣ�");
						continue;
					}
					
					System.out.println("������ʳƷ�۸�");
					foodPrice = input.nextDouble();
					
					food = new Food();//ʵ����һ���յ�ʳƷ�Ķ���
					
					/*ͨ����װ����Ϊfood��������Ը�ֵ*/
					food.setFoodName(foodName);
					food.setFoodPrice(foodPrice);
					
					result = fm.addFood(food);
					if (result != -1) {
						System.out.println("���" + foodName + "�ɹ�!");
					} else {
						System.out.println("�Բ������ʧ�ܣ�");
					}
					break;
				case 2:
					System.out.println("������ʳƷ����");
					foodName = input.next();
					food = fm.getFoodByName(foodName);
					if (food == null) {
						System.out.println("���޴�ʳƷ��Ϣ");
					} else {
						System.out.println("���ƣ�" + food.getFoodName() + ",�۸�" + food.getFoodPrice());
					}
					break;
				case 3:
					System.out.println("������ʳƷ����");
					foodName = input.next();
					food = fm.getFoodByName(foodName);
					if (food == null) {
						System.out.println("���޴�ʳƷ��Ϣ");
						continue;
					}
					
					System.out.println("������ʳƷ�۸�");
					foodPrice = input.nextDouble();
					
					result = fm.modifyFoodPriceByFoodName(foodName, foodPrice);
					if (result != -1) {
						System.out.println("�޸ĳɹ���");
					} else {
						System.out.println("�޸�ʧ��!");
					}
					break;
				case 4:
					double totalPrice = fm.getTotalPrice();
					System.out.println("������Ʒ���ܼ۸�" + totalPrice);
					break;
				case 5:
					Food[] maxPriceFood = fm.getMaxPriceFood();
					if (maxPriceFood == null) {
						System.out.println("������Ʒ��Ϣ��");
						continue;
					}
					System.out.println("����\t\t�۸�");
					for (int i = 0; i < maxPriceFood.length; i++) {
						food = maxPriceFood[i];
						System.out.println(food.getFoodName() + "\t\t" + food.getFoodPrice());
					}
					break;
				case 6:
					Food[] sortByFoodPrice = fm.sortByFoodPrice();
					System.out.println("����\t\t�۸�");
					for (int i = 0; i < sortByFoodPrice.length; i++) {
						food = sortByFoodPrice[i];
						if (food != null) {
							System.out.println(food.getFoodName() + "\t\t" + food.getFoodPrice());
						}
					}
					break;
				case 7:
					System.out.println("ллʹ�ã��ټ�!");
					return;
				default:
					System.out.println("�����������������룡");
					break;
			}
			System.out.println();
		} while (true);
	}

}
