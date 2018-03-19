package com.subarray;

public class MaxProductSubarray {

	
	public int maxProduct(int[] nums) {
    
		int maxGlobal = nums[0];
		int iMax = nums[0];
		int iMin = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			
			if(nums[i] < 0){
				//swap imax and imin
				 iMax = (iMin+iMax) - (iMin=iMax);  // y = (x+y) - (x=y);
			}
			
			iMax = Math.max(nums[i], iMax*nums[i]);
			iMin = Math.min(nums[i], iMin*nums[i]);
			
			maxGlobal = Math.max(maxGlobal, iMax);
		}
		return maxGlobal;
    }
	
}
