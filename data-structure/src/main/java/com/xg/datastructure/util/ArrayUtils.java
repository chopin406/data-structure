package com.xg.datastructure.util;

public class ArrayUtils {

	public static void printArray(int[] arr){
		StringBuffer sb = new StringBuffer("[");
		
		for(int i = 0; i < arr.length; i++){
			if(i == arr.length-1)
				sb.append(arr[i]).append("]");
			else
				sb.append(arr[i]).append(",");
		}
		System.out.println(sb.toString());
	}
}
