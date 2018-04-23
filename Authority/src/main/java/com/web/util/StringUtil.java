package com.web.util;

public class StringUtil {

	
	/**
	 * 截取图片的url地址
	 * //   Authority/attached/image/20180411/20180411104215_195.jpg
	 *       20180411/20180411104215_195.jpg
	 * @param str
	 * @return
	 */
	public static String getImageUrl(String str){
		String newStr = null;
		if(str != null){
			String[] arr1 = str.split("/");
			
			newStr = arr1[arr1.length-2] + "/" + arr1[arr1.length-1];
		}
		return newStr;
	}
	
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		
		if(str == null){
			return false;
		}
		return str.length() > 0 ? true : false;
	}
	
	
}
