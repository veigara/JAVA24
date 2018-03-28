package com.hxzy;

/**
 * 食品的管理类
 * @author Administrator
 *
 */
public class FoodManager {
	private Food[] foods = new Food[500];//最多存储500件食品
	
	//添加食品信息
	
	/**
	 * 添加食品信息到数组中
	 * @param food 从外部传递进来的食品的对象
	 * @return -1，添加失败。否认则代表添加成功
	 */
	public int addFood(Food food) {
		
		//验证食品的对象是否为空
		if (food == null) {
			return -1;
		}
		
		//将food存放到数组中为null的空间
		for (int i = 0; i < this.foods.length; i++) {
			if (foods[i] == null) {
				foods[i] = food;
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * 根据食品名称查询食品信息
	 * @param foodName
	 * @return
	 */
	public Food getFoodByName(String foodName) {
		for (int i = 0; i < this.foods.length; i++) {
			Food food = this.foods[i];//获取数组下标为i的Food的对象
			//只有foods对象数组中，不为空的元素，并且它的foodName属性值和参数foodName的值相等，才说明数组中存在已有名称的食品
			if (food != null && food.getFoodName().equals(foodName)) {
				return food;//强制使方法结束
			}
		}
		return null;
	}
	
	/**
	 * 根据食品名称修改食品信息
	 * @param foodName 要修改价格的食品名称
	 * @param foodPrice 修改后的价格
	 * @return
	 */
	public int modifyFoodPriceByFoodName(String foodName,double foodPrice) {
		for (int i = 0; i < this.foods.length; i++) {
			Food food = this.foods[i];
			if (food != null && food.getFoodName().equals(foodName)) {
				food.setFoodPrice(foodPrice);
				//this.foods[i] = food;   //这一条代码没有必要存在，因为food和this.foods[i]是同一个内存地址
				return i;
			}
		}
		return -1;//没有该食品信息
	}
	
	/**
	 * 计算所有食品的总价格
	 * @return
	 */
	public double getTotalPrice() {
		double sum = 0;
		for (int i = 0; i < this.foods.length; i++) {
			Food food = this.foods[i];
			if (food != null) {
				sum += food.getFoodPrice();
			}
		}
		return sum;
	}
	
	/*具有最高价格的食品，有可能不止一个*/
	public Food[] getMaxPriceFood() {
		
		//如果第一个元素都为空，说明数组其他元素也为空
		if (this.foods[0] == null) {
			return null;
		}
		
		Food max = this.foods[0];
		
		//确定最高价格是多少
		for (int i = 1; i < this.foods.length; i++) {
			Food food = this.foods[i];
			if (food != null && food.getFoodPrice() > max.getFoodPrice()) {
				max = food;
			}
		}
		
		//统计那些食品的价格和最高价格相同
		int count = 0;
		for (int i = 0; i < this.foods.length; i++) {
			Food food = this.foods[i];
			if (food != null && food.getFoodPrice() == max.getFoodPrice()) {
				count++;//统计最高价格食品的数量
			}
		}
		
		Food[] newFood = new Food[count];
		int j = 0;
		for (int i = 0; i < this.foods.length; i++) {
			Food food = this.foods[i];
			if (food != null && food.getFoodPrice() == max.getFoodPrice()) {
				newFood[j++] = food;
			}
		}
		return newFood;
	} 
	
	/**
	 * 通过插入排序，排序对象数组
	 * @return
	 */
	public Food[] sortByFoodPrice() {
		//排序
		for (int i = 1; i < this.foods.length - 1; i++) {
			int j = i;
			Food target = this.foods[i];
			
			if (target == null) { //线性数组，只要出现第一个null，则推断后面空间都是null
				break;
			}
			
			//需要注意：比较是对象的属性
			while (j > 0 && target.getFoodPrice() < this.foods[j - 1].getFoodPrice()) {
				this.foods[j] = this.foods[j - 1];
				j--;
			}
			if (i != j) {
				this.foods[j] = target;
			}
		}
		return this.foods;
	}
}
