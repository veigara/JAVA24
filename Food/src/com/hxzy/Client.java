package com.hxzy;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		System.out.println("欢迎使用XXX食品管理系统");
		Scanner input = new Scanner(System.in);
		FoodManager fm = new FoodManager();//引入食品管理类
				
		int choose;
		Food food;
		int result;
		String foodName;
		double foodPrice;
		do {
			System.out.println("请选择：");
			System.out.println("1.添加食品信息");
			System.out.println("2.根据食品名称，查询食品信息");
			System.out.println("3.根据食品名称，修改食品价格");
			System.out.println("4.计算所有食品总价");
			System.out.println("5.统计所有食品中最贵的商品信息");
			System.out.println("6.按照食品的价格升序排序输出这些食品的信息");
			System.out.println("7.退出");
			choose = input.nextInt();//接收用户的输入
			switch (choose) {
				case 1:
					System.out.println("请输入食品名称");
					foodName = input.next();
					
					//通过食品名称验证食品是否已经存在
					food = fm.getFoodByName(foodName);
					if (food != null) {//food为null，说明数组不存在该名字的食品
						System.out.println("该食品已存在！");
						continue;
					}
					
					System.out.println("请输入食品价格");
					foodPrice = input.nextDouble();
					
					food = new Food();//实例化一个空的食品的对象
					
					/*通过封装方法为food对象的属性赋值*/
					food.setFoodName(foodName);
					food.setFoodPrice(foodPrice);
					
					result = fm.addFood(food);
					if (result != -1) {
						System.out.println("添加" + foodName + "成功!");
					} else {
						System.out.println("对不起，添加失败！");
					}
					break;
				case 2:
					System.out.println("请输入食品名称");
					foodName = input.next();
					food = fm.getFoodByName(foodName);
					if (food == null) {
						System.out.println("查无此食品信息");
					} else {
						System.out.println("名称：" + food.getFoodName() + ",价格：" + food.getFoodPrice());
					}
					break;
				case 3:
					System.out.println("请输入食品名称");
					foodName = input.next();
					food = fm.getFoodByName(foodName);
					if (food == null) {
						System.out.println("查无此食品信息");
						continue;
					}
					
					System.out.println("请输入食品价格");
					foodPrice = input.nextDouble();
					
					result = fm.modifyFoodPriceByFoodName(foodName, foodPrice);
					if (result != -1) {
						System.out.println("修改成功！");
					} else {
						System.out.println("修改失败!");
					}
					break;
				case 4:
					double totalPrice = fm.getTotalPrice();
					System.out.println("所有商品的总价格：" + totalPrice);
					break;
				case 5:
					Food[] maxPriceFood = fm.getMaxPriceFood();
					if (maxPriceFood == null) {
						System.out.println("暂无商品信息！");
						continue;
					}
					System.out.println("名称\t\t价格");
					for (int i = 0; i < maxPriceFood.length; i++) {
						food = maxPriceFood[i];
						System.out.println(food.getFoodName() + "\t\t" + food.getFoodPrice());
					}
					break;
				case 6:
					Food[] sortByFoodPrice = fm.sortByFoodPrice();
					System.out.println("名称\t\t价格");
					for (int i = 0; i < sortByFoodPrice.length; i++) {
						food = sortByFoodPrice[i];
						if (food != null) {
							System.out.println(food.getFoodName() + "\t\t" + food.getFoodPrice());
						}
					}
					break;
				case 7:
					System.out.println("谢谢使用，再见!");
					return;
				default:
					System.out.println("输入有误，请重新输入！");
					break;
			}
			System.out.println();
		} while (true);
	}

}
