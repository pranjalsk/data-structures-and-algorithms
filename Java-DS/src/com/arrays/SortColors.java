package com.arrays;

public class SortColors {

	/**
	 * Given an array with n objects colored red, white or blue, sort them so
	 * that objects of the same color are adjacent, with the colors in the order
	 * red, white and blue.
	 * 
	 * Here, we will use the integers 0, 1, and 2 to represent the color red,
	 * white, and blue respectively.
	 * 
	 */
	public void sortColors(int[] nums) {

		//count red, blue and white balls, and modify the array susequently
		
		int num0 = 0;
		int num1 = 0;
		int num2 = 0;
		
		for(int num : nums){
			if(num == 0) num0 += 1;
			else if(num == 1) num1 += 1;
			else if(num == 2) num2 += 1;
		}
		
		for(int i =0;i<num0;i++){
			nums[i] = 0;
		}
		for(int i =0;i<num1;i++){
			nums[num0 + i] = 1;
		}
		for(int i =0;i<num2;i++){
			nums[num0 + num1 + i] = 2;
		}
		
    }
	
	
}
