package com.xg.datastructure.insertion;

import com.xg.datastructure.util.ArrayUtils;

/**
 * 折半插入排序
 * @author chopin
 * 4, 12, 2, 21, 88, 19, 31, 22, 76, 5
 */
public class BinaryInsertionSort {

	public static void main(String[] args) {
		BinaryInsertionSort t = new BinaryInsertionSort();
		
		t.sort1(Data.array);
	}
	public void sort1(int arr[]){
		int flag = 0, m = 0;
		
		for(int i = 1 ; i<arr.length; i++){
			int low = 1;
			int high = i;
			flag = arr[i];
			while(low <= high){
				m = (low+high)/2;
				
				if(flag < arr[m-1])
					high = m-1;
				else
					low = m+1;
			}
			for(int j = i-1; j >= high; j--){
				arr[j+1] = arr[j];
			}
			arr[high] = flag;
		}
		ArrayUtils.printArray(arr);
	}
	
}
