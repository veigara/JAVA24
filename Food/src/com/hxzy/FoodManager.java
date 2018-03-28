package com.hxzy;

/**
 * ʳƷ�Ĺ�����
 * @author Administrator
 *
 */
public class FoodManager {
	private Food[] foods = new Food[500];//���洢500��ʳƷ
	
	//���ʳƷ��Ϣ
	
	/**
	 * ���ʳƷ��Ϣ��������
	 * @param food ���ⲿ���ݽ�����ʳƷ�Ķ���
	 * @return -1�����ʧ�ܡ������������ӳɹ�
	 */
	public int addFood(Food food) {
		
		//��֤ʳƷ�Ķ����Ƿ�Ϊ��
		if (food == null) {
			return -1;
		}
		
		//��food��ŵ�������Ϊnull�Ŀռ�
		for (int i = 0; i < this.foods.length; i++) {
			if (foods[i] == null) {
				foods[i] = food;
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * ����ʳƷ���Ʋ�ѯʳƷ��Ϣ
	 * @param foodName
	 * @return
	 */
	public Food getFoodByName(String foodName) {
		for (int i = 0; i < this.foods.length; i++) {
			Food food = this.foods[i];//��ȡ�����±�Ϊi��Food�Ķ���
			//ֻ��foods���������У���Ϊ�յ�Ԫ�أ���������foodName����ֵ�Ͳ���foodName��ֵ��ȣ���˵�������д����������Ƶ�ʳƷ
			if (food != null && food.getFoodName().equals(foodName)) {
				return food;//ǿ��ʹ��������
			}
		}
		return null;
	}
	
	/**
	 * ����ʳƷ�����޸�ʳƷ��Ϣ
	 * @param foodName Ҫ�޸ļ۸��ʳƷ����
	 * @param foodPrice �޸ĺ�ļ۸�
	 * @return
	 */
	public int modifyFoodPriceByFoodName(String foodName,double foodPrice) {
		for (int i = 0; i < this.foods.length; i++) {
			Food food = this.foods[i];
			if (food != null && food.getFoodName().equals(foodName)) {
				food.setFoodPrice(foodPrice);
				//this.foods[i] = food;   //��һ������û�б�Ҫ���ڣ���Ϊfood��this.foods[i]��ͬһ���ڴ��ַ
				return i;
			}
		}
		return -1;//û�и�ʳƷ��Ϣ
	}
	
	/**
	 * ��������ʳƷ���ܼ۸�
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
	
	/*������߼۸��ʳƷ���п��ܲ�ֹһ��*/
	public Food[] getMaxPriceFood() {
		
		//�����һ��Ԫ�ض�Ϊ�գ�˵����������Ԫ��ҲΪ��
		if (this.foods[0] == null) {
			return null;
		}
		
		Food max = this.foods[0];
		
		//ȷ����߼۸��Ƕ���
		for (int i = 1; i < this.foods.length; i++) {
			Food food = this.foods[i];
			if (food != null && food.getFoodPrice() > max.getFoodPrice()) {
				max = food;
			}
		}
		
		//ͳ����ЩʳƷ�ļ۸����߼۸���ͬ
		int count = 0;
		for (int i = 0; i < this.foods.length; i++) {
			Food food = this.foods[i];
			if (food != null && food.getFoodPrice() == max.getFoodPrice()) {
				count++;//ͳ����߼۸�ʳƷ������
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
	 * ͨ���������������������
	 * @return
	 */
	public Food[] sortByFoodPrice() {
		//����
		for (int i = 1; i < this.foods.length - 1; i++) {
			int j = i;
			Food target = this.foods[i];
			
			if (target == null) { //�������飬ֻҪ���ֵ�һ��null�����ƶϺ���ռ䶼��null
				break;
			}
			
			//��Ҫע�⣺�Ƚ��Ƕ��������
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
