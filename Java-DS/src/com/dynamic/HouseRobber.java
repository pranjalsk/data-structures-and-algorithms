package com.dynamic;

public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * You are a professional robber planning to rob houses along a street. Each
	 * house has a certain amount of money stashed, the only constraint stopping
	 * you from robbing each of them is that adjacent houses have security
	 * system connected and it will automatically contact the police if two
	 * adjacent houses were broken into on the same night.
	 * 
	 * Given a list of non-negative integers representing the amount of money of
	 * each house, determine the maximum amount of money you can rob tonight
	 * without alerting the police.
	 * 
	 * @param nums
	 * @return
	 */
	//https://www.youtube.com/watch?v=YXPsaVdyopM
	public int rob(int[] nums) {

		if (nums.length == 0)
			return 0;

		// using dp
		// max value at given index i temp[i]= Max(A[i]+temp[i-2] , temp[i-1])
		
		//max value at a given house = max( currHouseval+ maxAtTwoHousePriorThat , maxAtHouseJustBeforeCurr  )

		int n = nums.length;
		int[] temp = new int[n + 1];

		temp[0] = 0;
		temp[1] = nums[0];

		for (int i = 2; i < temp.length; i++) {

			temp[i] = Math.max(nums[i - 1] + temp[i - 2], temp[i - 1]);

		}

		return temp[temp.length - 1];

	}

}
