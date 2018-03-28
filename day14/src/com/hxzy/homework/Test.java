package com.hxzy.homework;

import java.util.Arrays;
import java.util.Comparator;

import net.sourceforge.pinyin4j.PinyinHelper;

public class Test {

	public static void main(String[] args) {
		String[] arr = {"周洪欣","明宇","李林松"};
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return ToPinYinString(o1).compareTo(ToPinYinString(o2));
			}
			
			private String ToPinYinString(String str){    
                
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
		});
		for (String string : arr) {    
            System.out.println(string);    
        }
		
		System.out.println("--------------");
		int i = '宇';	//zhou1hong2xin1    ming2yu3
		String hexString = Integer.toHexString(i);
		System.out.println("zhou1hong2xin1".compareTo("ming2yu3"));
	}

}
