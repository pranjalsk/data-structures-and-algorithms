package com.whatSumProblems;

import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int current = nums[i];
			int other = target - current;
			if (map.containsKey(other)) {
				return new int[] { (int) map.get(other), i };
			} else {
				map.put(current, i);
			}
		}
		return null;
	}

	// if array is sorted
	public int[] twoSumInSorted(int[] num, int target) {
		int[] indice = new int[2];
		if (num == null || num.length < 2)
			return indice;
		
		int left = 0, right = num.length - 1;
		
		while (left < right) {
			
			int v = num[left] + num[right];
			
			if (v == target) {
				indice[0] = left + 1;
				indice[1] = right + 1;
				break;
			} 
			else if (v > target) {
				right--;
			} else {
				left++;
			}
		}
		return indice;
	}
}
