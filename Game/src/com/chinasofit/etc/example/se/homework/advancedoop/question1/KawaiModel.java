/**
 *  Copyright 2009 ChinaSoft International Ltd. All rights reserved.
 */

package com.chinasofit.etc.example.se.homework.advancedoop.question1;
import java.util.*;
/**
 * <p>Title: KawaiModel</p>
 * <p>Description: ��������Ϸ����ģ�������</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: ChinaSoft International Ltd.</p>
 * @author etc
 * @version 1.0
 */
public abstract class KawaiModel {

	/**
	 * �����������ͼԪ������
	 */
	public int[][] map;
	/**
	 * ���ʹ����ʾ���ܺ�ϵͳ���ҵ��ĵ�һ��Ԫ�ص���ֵ
	 */
	public int pointItemAI;
	/**
	 * ���ʹ����ʾ���ܺ�ϵͳ���ҵ��ĵ�һ��Ԫ�ص���ֵ
	 */
	public int pointItemAJ;
	/**
	 * ���ʹ����ʾ���ܺ�ϵͳ���ҵ��ĵڶ���Ԫ�ص���ֵ
	 */
	public int pointItemBI;
	/**
	 * ���ʹ����ʾ���ܺ�ϵͳ���ҵ��ĵڶ���Ԫ�ص���ֵ
	 */
	public int pointItemBJ;
//	/**
//	 * ��ŵ�һ���۵����ֵ����������������£��ڶ����۵����һ��Ԫ������
//	 */
//	public int turningPointAI;
//	/**
//	 * ��ŵ�һ���۵����ֵ����������������£��ڶ����۵����һ��Ԫ������
//	 */
//	public int turningPointAJ;
//	/**
//	 * ��ŵڶ����۵����ֵ
//	 */
//	public int turningPointBI;
//	/**
//	 * ��ŵڶ����۵����ֵ
//	 */
//	public int turningPointBJ;
	
	
	/**
	 * ����۵�
	 */
	public Node[] turningPoints=new Node[2];
	
	public abstract String getModelName();
	
//	public void setMaxTurnCount(int count){
//		turningPoints=new Node[count];
//	}
//	

	
	public void setTurningPoints(int i,int j,int position){
		
		
		if(turningPoints[position-1]==null){
			turningPoints[position-1]=new Node();
		}
		Node node=turningPoints[position-1];
		node.setI(i);
		node.setJ(j);
		
		
	}

	
	/**
	* ���õ�ͼ���飬��ģ�����в�����������һ����������Ļ���֮��
	* @param map һ��int�Ͷ�ά���飬��������ģ����Ԫ�ص�״̬
	*/
	public void setMap(int[][] map) {
		this.map = map;
	}
	
	/**
	 * ������ɳ�ʼ����ͼ�ķ���
	 * @param elementCount ��ͼԪ�ص��ܸ���(����Ϊż�����ҵ���(rowCount-2)*(columnCount-2))
	 * @param rowCount ��ͼ������
	 * @param columnCount ��ͼ������
	 * @param elementTypeCount Ԫ�ص������������Ŵ�1��elementTypeCount����׼������Ϊ29��Ԫ�أ�
	 * @return int�Ͷ�ά���飬���������ɵĵ�ͼ
	 * @exception java.lang.IllegalArgumentException ������ݵ�Ԫ���ܸ�����Ϊż����Ԫ���ܸ���������(����-2)*(����-2)�����׳��쳣
	 * */
	public int[][] initMapHelper(int elementCount,int rowCount,int columnCount,int elementTypeCount){
		if ((elementCount % 2 != 0)
				&& (elementCount != ((rowCount - 2) * (columnCount - 2)))) {// �������������Ҫ�����׳��쳣
			throw new java.lang.IllegalArgumentException();
		}

		Random random = new Random();
		int[] initElement = new int[elementCount];// ����һ����ʱ��һλ���鱣���ʼ��Ԫ��
		for (int i = 0; i < elementCount; i+=2) {

			int randomNum = Math.abs(random.nextInt()) % elementTypeCount + 1;// ��ȡ���Ԫ������
			initElement[i] = randomNum;
			initElement[i + 1] = randomNum;// һ���Զ����ڵ�����Ԫ�ظ�ֵ����֤����õ���elementCount/2����Ԫ��

		}

		// ������ҵõ���ԭʼ����
		initElement = getRandomArrayHelper(initElement);

		// �����Һ��һά���鿽�������Ķ�ά���飬ע�⣬��������Ϸ��ͼ����Ȧ��һȦ0

		int[][] finalMap = new int[rowCount][columnCount];
		int index = 0;
		for (int i = 1; i < rowCount - 1; i++) {
			for (int j = 1; j < columnCount-1; j++) {

				finalMap[i][j] = initElement[index];
				index++;
			}

		}

		return finalMap;
	}
	
	/**
	 * �������ԭʼ����
	 * 
	 * @param srcArray int�����飬���δ���ҵ�ԭʼ����
	 * @return int�����飬��Ŵ��Һ�Ľ��
	 */
	public int[] getRandomArrayHelper(int[] srcArray){
		
		Random random=new Random();
		int resultArray[]=new int[srcArray.length];
		//srcIndex:��ʣ�µ�Ԫ�ظ���
		int srcIndex=srcArray.length;		
		for(int i=0;i<srcArray.length;i++){
			int randomIndex=Math.abs(random.nextInt()%srcIndex);//���ȡ�����±�
			resultArray[i]=srcArray[randomIndex];
			srcArray[randomIndex]=srcArray[--srcIndex];//�����һ��δʹ�õ�Ԫ�غ�ȡ������Ԫ�ؽ���	
			
		}				
		
		return resultArray;	
		
	}
	
	
	
	
	/**
	* �ж�����Ԫ���Ƿ��ܹ�ͨ��һ��ֱ������
	* @param itemAI ��һ��Ԫ�ص���ֵ
	* @param itemAJ ��һ��Ԫ�ص���ֵ
	* @param itemBI �ڶ���Ԫ�ص���ֵ
	* @param itemBJ �ڶ���Ԫ�ص���ֵ
	* @return ����ֵ�����ΪTrue��˵������Ԫ���ܹ�ͨ��һ��ֱ�����ӣ���֮��������Ԫ�ز���ͨ��һ��ֱ������
	*/
	public boolean linkByLine(int itemAI,int itemAJ,int itemBI,int itemBJ){
		if (itemAI == itemBI) {// ����Ԫ����һ��ˮƽ����

			int minJ = itemAJ < itemBJ ? itemAJ : itemBJ;
			int maxJ = itemAJ < itemBJ ? itemBJ : itemAJ;

			for (int j = minJ + 1; j < maxJ; j++) {
				if (map[itemAI][j] != 0) {
					return false;
				}
			}

			return true;
		} else if (itemAJ == itemBJ) {// ����Ԫ����һ����ֱ����

			int minI = itemAI < itemBI ? itemAI : itemBI;
			int maxI = itemAI < itemBI ? itemBI : itemAI;
			for (int i = minI + 1; i < maxI; i++) {

				if (map[i][itemAJ] != 0) {

					return false;
				}

			}

			return true;
		} else {// ����Ԫ�ز���һ��ֱ����
			return false;
		}
	}
	
	/**
	* �ж�����Ԫ���Ƿ��ܹ�ͨ��һ��ת������
	* @param itemAI ��һ��Ԫ�ص���ֵ
	* @param itemAJ ��һ��Ԫ�ص���ֵ
	* @param itemBI �ڶ���Ԫ�ص���ֵ
	* @param itemBJ �ڶ���Ԫ�ص���ֵ
	* @return ����ֵ�����ΪTrue��˵������Ԫ���ܹ�ͨ��һ��ת�����ӣ���֮��������Ԫ�ز���ͨ��һ��ת������
	*/
	public boolean linkByOneTurn(int itemAI,int itemAJ,int itemBI,int itemBJ){
		
		// �������Ԫ���ܹ�һ�����ӣ���ô�۵��ǹ̶��ģ�����itemAI,itemBJ����itemBI,itemAJ��
		if ((map[itemAI][itemBJ] == 0)
				&& linkByLine(itemAI, itemAJ, itemAI, itemBJ)
				&& linkByLine(itemBI, itemBJ, itemAI, itemBJ)) {

			setTurningPoints(itemAI,itemBJ,1);
			
			
//			turningPointAI = itemAI;
//			turningPointAJ = itemBJ;// �����۵���Ϣ

			return true;
		} else if ((map[itemBI][itemAJ] == 0)
				&& linkByLine(itemAI, itemAJ, itemBI, itemAJ)
				&& linkByLine(itemBI, itemBJ, itemBI, itemAJ)) {
//			turningPointAI = itemBI;
//			turningPointAJ = itemAJ;

			setTurningPoints(itemBI,itemAJ,1);
			
			return true;

		} else {

			return false;
		}
	}
	
	/**
	* �ж�����Ԫ���Ƿ��ܹ�ͨ������ת������
	* @param itemAI ��һ��Ԫ�ص���ֵ
	* @param itemAJ ��һ��Ԫ�ص���ֵ
	* @param itemBI �ڶ���Ԫ�ص���ֵ
	* @param itemBJ �ڶ���Ԫ�ص���ֵ
	* @return ����ֵ�����ΪTrue��˵������Ԫ���ܹ�ͨ������ת�����ӣ���֮��������Ԫ�ز���ͨ������ת������
	*/
	public boolean linkByTwoTurn(int itemAI,int itemAJ,int itemBI,int itemBJ){
		
		for(int i=0;i<map.length;i++){
			
			if(map[i][itemAJ]==0&&linkByLine(i,itemAJ,itemAI,itemAJ)&&linkByOneTurn(i,itemAJ,itemBI,itemBJ)){
//				turningPointBI=i;
//				turningPointBJ=itemAJ;
				
				setTurningPoints(i,itemAJ,2);
				return true;
			}
			
			
		}
		
		for(int j=0;j<map[itemAI].length;j++){
			
			if(map[itemAI][j]==0&&linkByLine(itemAI,j,itemAI,itemAJ)&&linkByOneTurn(itemAI,j,itemBI,itemBJ)){
				
//				turningPointBI=itemAI;
//				turningPointBJ=j;
				setTurningPoints(itemAI,j,2);
				return true;	
			}
			
		}
		
		return false;
	}
	/**
	 * �ж�����Ԫ���Ƿ��ܹ�����
	 * 
	 * @param itemAI
	 *            ��һ��Ԫ�ص���ֵ
	 * @param itemAJ
	 *            ��һ��Ԫ�ص���ֵ
	 * @param itemBI
	 *            �ڶ���Ԫ�ص���ֵ
	 * @param itemBJ
	 *            �ڶ���Ԫ�ص���ֵ
	 * @return byteֵ<br>
	 *         ����ֵΪ0����ʾ����Ԫ���޷�����<br>
	 *         ����ֵΪ1��ʾ����Ԫ���ܹ�ͨ��һ��ֱ������<br>
	 *         ����ֵΪ2��ʾ����Ԫ���ܹ�ͨ��һ��ת������<br>
	 *         ����ֵΪ3��ʾ����Ԫ���ܹ�ͨ������ת������
	 *@see KawaiModel #linkByLine(int, int, int, int)
	 *@see KawaiModel #linkByOneTurn(int, int, int, int)
	 *@see KawaiModel #linkByTwoTurn(int, int, int, int)
	 */
	public abstract byte isConnected(int itemAI,int itemAJ,int itemBI,int itemBJ);
	/**
	 * ����ͼ�д�������Ϊ��0Ԫ�أ�������Ϊ0ʱ��������Ԫ�ضԵ�
	 * @return ����ֵ����ʾ�Ƿ�ִ�й��Ե�����
	 * */
	public boolean downHelper() {
		
		boolean change = false;
		for (int i = map.length - 2; i > 1; i--) {
			for (int j = 0; j < map[i].length; j++) {

				if (map[i][j] == 0 && map[i - 1][j] != 0) {
					map[i][j] = map[i - 1][j];
					map[i - 1][j] = 0;
					change = true;
				}
			}

		}
		return change;
	}
	/**
	 * ����ͼ�����з�0Ԫ�����´��ķ���
	 */
	public void downMove() {
		while(downHelper());

	}
	/**
	 * ����ͼ�д�������Ϊ��0Ԫ�أ�������Ϊ0ʱ��������Ԫ�ضԵ�
	 * @return ����ֵ����ʾ�Ƿ�ִ�й��Ե�����
	 * */
	public boolean upHelper() {

		boolean change = false;
		for (int i = 1; i < map.length-1; i++) {
			for (int j = 0; j < map[i].length; j++) {

				if (map[i][j] == 0 && map[i + 1][j] != 0) {
					map[i][j] = map[i + 1][j];
					map[i + 1][j] = 0;
					change = true;
				}
			}

		}
		return change;
	}
	/**
	 * ����ͼ�����з�0Ԫ�����ϴ��ķ���
	 */
	public void upMove() {
		while(upHelper());
	}
	/**
	 * ����ͼ�д�������Ϊ��0Ԫ�أ�������Ϊ0ʱ��������Ԫ�ضԵ�
	 * @return ����ֵ����ʾ�Ƿ�ִ�й��Ե�����
	 */
	public boolean leftHelper() {
		boolean change = false;
		for (int i = 0; i < map.length; i++) {

			for (int j = map[i].length - 2; j > 1; j--) {

				if (map[i][j] == 0 && map[i][j - 1] != 0) {
					map[i][j] = map[i][j - 1];
					map[i][j - 1] = 0;
					change = true;

				}
			}

		}

		return change;
	}
	/**
	 * ����ͼ�����з�0Ԫ�����󴮵ķ���
	 */
	public void leftMove() {
		while(leftHelper());
	}
	/**
	 * ����ͼ�д�������Ϊ��0Ԫ�أ�������Ϊ0ʱ��������Ԫ�ضԵ�
	 * @return ����ֵ����ʾ�Ƿ�ִ�й��Ե�����
	 */
	public boolean rightHelper() {

		boolean change = false;
		for (int i = 0; i < map.length; i++) {

			for (int j = 1; j < map[i].length-1; j++) {

				if (map[i][j] == 0 && map[i][j + 1] != 0) {
					map[i][j] = map[i][j + 1];
					map[i][j + 1] = 0;
					change = true;

				}
			}

		}

		return change;
	}
	/**
	 * ����ͼ�����з�0Ԫ�����Ҵ��ķ���
	 */
	public void rightMove() {
		while(rightHelper());
	}
	/**
	 *�ж�Ŀǰ�ĵ�ͼ״̬�Ƿ��Ѿ����أ����һ����ͼ�����е�Ԫ�ض�Ϊ0�����ʾ���е�Ԫ�ض��Ѿ�����������
	 *@return ����ֵ�����Ϊtrue�����ʾ�Ѿ����أ����Ϊfalse���ʾ��δ���� 
	 */
	public boolean isPass(){
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 *�����ڵ�ͼ����ϴ�Ƶķ�������Ϸ�����������û��Լ��޷��ҵ��������ӵ�Ԫ�ضԣ�ϣ����������ϴ��ʱ���� 
	 */
	public void resetMapHelper(){
		//����Ŀǰ��ͼ�л����ڶ���Ԫ��
		int elementCount = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0) {
					elementCount++;
				}
			}
		}
		//����һ����ʱ���鱣������Ԫ��
		int[] element=new int[elementCount];
		int index=0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0) {
					element[index]=map[i][j];
					index++;
				}
			}
		}
		//�������������
		element=getRandomArrayHelper(element);
		//�����Һ�Ľ���Żص�ͼ����
		index=0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0) {
					map[i][j]=element[index];
					index++;
				}
			}
		}
	}
	/**
	 * ��ӡ�������״̬���
	* @param itemAI ��һ��Ԫ�ص���ֵ
	* @param itemAJ ��һ��Ԫ�ص���ֵ
	* @param itemBI �ڶ���Ԫ�ص���ֵ
	* @param itemBJ �ڶ���Ԫ�ص���ֵ
	 */
	public void showConnectState(int itemAI,int itemAJ,int itemBI,int itemBJ){
		
		int code=isConnected(itemAI,itemAJ,itemBI,itemBJ);
		if(code==0){
			
			System.out.println(">>>���:�Բ��𣬰��չ��������ڵ㲻������");
						
		}else{
			
			
			System.out.println(code+">>>���:��ϲ�����չ��������ڵ�������ӣ�����·�����£�");
			
			StringBuffer line=new StringBuffer();
			line.append("(");
			line.append(itemAI);
			line.append(",");
			line.append(itemAJ);
			line.append(")->");
			
			for(int i=code-2;i>=0;i--){
				Node node=turningPoints[i];
				line.append("(");
				line.append(node.getI());
				line.append(",");
				line.append(node.getJ());
				line.append(")->");
			}
			line.append("(");
			line.append(itemBI);
			line.append(",");
			line.append(itemBJ);
			line.append(")");
			System.out.println(line.toString());
			
//			switch (code) {
//			case 1:
//				System.out.println("(" + itemAI + "," + itemAJ + ")->("
//						+ itemBI + "," + itemBJ + ")");
//				break;
//			case 2:
//				System.out.println("(" + itemAI + "," + itemAJ + ")->("
//						+ turningPointAI + "," + turningPointAJ + ")->("
//						+ itemBI + "," + itemBJ + ")");
//				break;
//			case 3:
//				System.out.println("(" + itemAI + "," + itemAJ + ")->("
//						+ turningPointBI + "," + turningPointBJ + ")->("
//						+ turningPointAI + "," + turningPointBJ + ")->("
//						+ itemBI + "," + itemBJ + ")");
//
//				break;
//
//			}
		}
		
	}
	
	/**
	 * ���ڶ��û�������ʾ���ҳ�һ�Կ������ӵ�Ԫ��
	 * @return booleanֵ��
	 * ���Ϊtrue��˵�������ڿ������ӵ�Ԫ�ضԣ������꽫�����pointItemAI��pointItemAJ��pointItemBI��pointItemBJ�ĸ���Ա�У�
	 * �������ֵΪfalse��˵����Ϸ�Ѿ������������ڿ������ӵ�Ԫ�ض���
	 */
	public boolean pointHelper(){
		
		for (int i = 1; i < map.length - 1; i++) {// ��������ѭ�������ҵ�һ��Ԫ��
			for (int j = 1; j < map[i].length - 1; j++) {// ѭ��ʱȥ������Ȧ��0Ԫ�أ���΢�Ż�����

				for (int i1 = 1; i1 < map.length - 1; i1++) {// ��������ѭ�������ҵض���Ԫ�أ�˼�����Ƿ����Ż��Ŀ���
					for (int j1 = 1; j1 < map[i].length - 1; j1++) {

						if (isConnected(i, j, i1, j1) != 0) {

							pointItemAI = i;
							pointItemAJ = j;
							pointItemBI = i1;
							pointItemBJ = j1;
							return true;

						}
					}
				}
			}
		}
		return false;
	}	
	
	
}
