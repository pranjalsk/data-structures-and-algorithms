package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> tempList = new ArrayList<>();
		subsetBacktrack(result, tempList, nums, 0);
		return result;
    }

	private void subsetBacktrack(List<List<Integer>> result, List<Integer> tempList, int[] nums,int start) {
		result.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			
			tempList.add(nums[i]);
			subsetBacktrack(result, tempList, nums, i+1);
			tempList.remove(tempList.size()-1);
			
		}
		
	}
	

}
