package com.arrays;

import java.util.ArrayList;

public class PeakElement {

	public static void main(String[] args) {
		
		System.out.println("Peak elements are:");
		System.out.println(findPeakElement(new int[]{1,2}));
		System.out.println(findPeakElement(new int[]{1,2,3,1}));
		System.out.println(findPeakElement(new int[]{1}));

	}

	public static int findPeakElement(int[] nums) {

		ArrayList<Integer> indexStg = new ArrayList<>();

		if (nums.length == 1)
			return nums[0];

		if (nums[0] > nums[1])
			return nums[0];

		int i = 1;
		for (; i < nums.length - 1; i++) {
			if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) {
				indexStg.add(nums[i]);
			}
		}
		return indexStg.size() > 0 ? indexStg.get(0) : nums[i];

	}

}
