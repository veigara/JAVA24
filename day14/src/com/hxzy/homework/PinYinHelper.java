package com.hxzy.homework;

import net.sourceforge.pinyin4j.PinyinHelper;

public class PinYinHelper {
	
	public static String toPinYinString(String str) {
		StringBuilder sb=new StringBuilder();    
        String[] arr=null;    
            
        for(int i=0;i<str.length();i++){    
            arr=PinyinHelper.toHanyuPinyinStringArray(str.charAt(i));    
            if(arr!=null && arr.length>0){    
                for (String string : arr) {    
                    sb.append(string);    
                }    
            }    
        } 
        return sb.toString();
	}
}
