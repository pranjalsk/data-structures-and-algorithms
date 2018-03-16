package com.histogram;

public class MaxRainwaterTrapped {

	// Hard Problem...
	/**
	 * Given n non-negative integers representing an elevation map where the
	 * width of each bar is 1, compute how much water it is able to trap after
	 * raining.
	 * 
	 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 * 
	 */

	// Brute force
	/**
	 * At any given bar...how much water can we trap we need to see its left
	 * "Max" boundary and right "Max" boundary trapped water =
	 * (min(leftmax,rightmax) - ht of self) * width
	 * 
	 */

	public int trap(int[] height) {

		int total = 0;
		int width = 1;

		// for 0th bar there is not left boundry...so we can not trap any water
		// on top of bar 0
		for (int i = 1; i < height.length; i++) {

			int lMax = 0;
			int rMax = 0;

			for (int j = i; j >= 0; j--) {
				lMax = Math.max(lMax, height[j]);
			}
			for (int j = i; j < height.length; j++) {
				rMax = Math.max(rMax, height[j]);
			}

			int trapOnBar = (Math.min(lMax, rMax) - height[i]) * width;

			total += trapOnBar;
		}

		return total;
	}

	// Approach 2 but with extra mem O(n)... but O(n) in time
	public int trap2(int[] height) {

		int n = height.length;
		int[] maxSeenLeft = new int[n];
		int[] maxSeenRight = new int[n];
		int total = 0;

		int maxSoFar = 0;
		for (int i = 0; i < height.length; i++) {
			maxSoFar = Math.max(maxSoFar, height[i]);
			maxSeenLeft[i] = maxSoFar;
		}

		maxSoFar = 0;
		for (int i = height.length - 1; i >= 0; i--) {
			maxSoFar = Math.max(maxSoFar, height[i]);
			maxSeenRight[i] = maxSoFar;
		}

		for (int i = 0; i < height.length; i++) {

			int trapWater = Math.min(maxSeenLeft[i], maxSeenRight[i]) - height[i];

			total += trapWater;
		}

		return total;
	}

	// 2 pointer approach
	public int trap3(int[] height) {

		int l = 0;
		int r = height.length - 1;
		int maxLeft = 0;
		int maxRight = 0;
		int total = 0;

		while (l < r) {
			maxLeft = Math.max(maxLeft, height[l]);
			maxRight = Math.max(maxRight, height[r]);

			if (maxLeft <= maxRight) {
				total += maxLeft - height[l];
				l++;
			} else {
				total += maxRight - height[r];
				r--;
			}
		}
		return total;

	}

}
