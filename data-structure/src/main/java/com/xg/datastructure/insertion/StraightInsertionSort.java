package com.xg.datastructure.insertion;

import com.xg.datastructure.util.ArrayUtils;

/**
 * 直接插入排序
 * 
 * @author chopin
 * 
 */
public class StraightInsertionSort {

	public static void main(String[] args) {
		StraightInsertionSort t = new StraightInsertionSort();
		int arr[] = { 14, 12, 2, 21, 88, 19, 31, 22, 76, 5 };
//		t.sort1(arr);
		t.sort2(arr);
//		t.sort3(arr);
	}

	public void sort1(int[] arr) {
		int flag = 0;
		int count = 1;	
		for (int i = 1; i < arr.length; i++) {// i从左到右添加元素

			if (arr[i] < arr[i - 1]) {

				flag = arr[i];
				arr[i] = arr[i - 1];

				for (int j = i - 2; j >= 0; j--) {// j从右到左比较元素
					if (flag < arr[j]) {
						arr[j + 1] = arr[j];
						if (j == 0)
							arr[0] = flag;
						count++;
					} else {
						arr[j + 1] = flag;count++;
						break;
					}
				}
				count++;
			}
			count++;
		}
		ArrayUtils.printArray(arr);
		System.out.println(count);
	}

	/**
	 * 对sort1比较大小代码的简化，比较大小的时候flag比关键字大就不需要再比较了
	 * j的作用就是从后往前标识关键字和flag比较前的位置，由于arr已经比较过一次了，所以j从i-2开始。
	 * 
	 * @param arr
	 */
	public void sort2(int[] arr) {
		int flag = 0;
		int count = 1;
		for (int i = 1; i < arr.length; i++) {// i从左到右添加元素

			if (arr[i] < arr[i - 1]) {

				flag = arr[i];
				arr[i] = arr[i - 1];
				int j = i - 2;
				for (; j >= 0 && flag < arr[j]; j--) {// j从右到左比较元素

					arr[j + 1] = arr[j];count++;
				}
				arr[j + 1] = flag;
				count++;
			}
			count++;

		}
		ArrayUtils.printArray(arr);
		System.out.println(count);
	}

	/**
	 * 简化sort2，第一次的arr[i] < arr[i - 1]比较完全可以放到j所在的for循环中比较
	 * 这才是完整的表述，将新的记录添加到有序列表中，逐个比较有序列表中的元素，当大于某个关键字时则停止
	 * 然后将数据插入到该关键字的后面
	 * @param arr
	 */
	public void sort3(int[] arr) {
		int flag = 0; int count = 1;
		for (int i = 1; i < arr.length; i++) {// 从第i个元素开始后顺序添加元素

			flag = arr[i];

			int j = i - 1;
			// 从第i-1个元素开始逆序比较元素，如果flag还是小于关键字，则继续循环，直到大于关键字或者小于首元素
			for (; j >= 0 && flag < arr[j]; j--) {

				arr[j + 1] = arr[j]; 
				count++;
			}
			arr[j + 1] = flag; count++;

		}
		ArrayUtils.printArray(arr);
		System.out.println(count);
	}

}
