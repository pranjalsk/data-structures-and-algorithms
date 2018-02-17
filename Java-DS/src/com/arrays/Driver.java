package com.arrays;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {

		ArrayOperations obj = new ArrayOperations();
		
		int [] arr = new int [] { 7, 6, 4, 8, 7, 8, 1, 0, -4};
		
	//	obj.kthlargestElement(arr, 2);
		
		//obj.countAndSay(5);
		
		String strarr [] = new String[]{"abcz","abcdfg","abc"};
		
		Arrays.sort(strarr);
		
		for(String str:strarr){
			System.out.println(str);
		}
		

	}

}
