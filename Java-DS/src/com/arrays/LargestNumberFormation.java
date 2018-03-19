package com.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFormation {

	public static void main(String[] args) {

	}

	/**
	 * Given a list of non negative integers, arrange them such that they form
	 * the largest number.
	 * 
	 * For example, given [3, 30, 34, 5, 9], the largest formed number is
	 * 9534330.
	 * 
	 * Note: The result may be very large, so you need to return a string
	 * instead of an integer.
	 */
	public String largestNumber(int[] nums) {

		//convert int arr to array of string
		String [] strArr = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strArr[i] = String.valueOf(nums[i]);
		}
		
		Arrays.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String concat1 = o1.concat(o2);
				String concat2 = o2.concat(o1);
				return concat2.compareTo(concat1); //this line is imp, compare concat2 with concat1 for decreasing order 
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(String s : strArr){
			sb.append(s);
		}
		
		//remove leading zeros for the case of all zeros
		while(sb.charAt(0)=='0'&&sb.length()>1)
            sb.deleteCharAt(0);
        
        return sb.toString();
	}

}
