package com.histogram;

public class MostWaterInContainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Container with most water
	/**
	 * Given n non-negative integers a1, a2, ..., an, where each represents a
	 * point at coordinate (i, ai). n vertical lines are drawn such that the two
	 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
	 * together with x-axis forms a container, such that the container contains
	 * the most water.
	 * 
	 * Note: You may not slant the container and n is at least 2.
	 */
	// brute force
	public int maxWaterInContainer1(int[] height) {

		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {

				int area = Math.min(height[i], height[j]) * (j - i);
				maxArea = Math.max(maxArea, area);
			}
		}

		return maxArea;
	}

	// two pointer approach
	// https://leetcode.com/problems/container-with-most-water/solution/
	public int maxWaterInContainer2(int[] height) {

		int maxArea = 0;
		int l = 0;
		int r = height.length - 1;

		while (l < r) {

			int area = Math.min(height[l], height[r]) * (r - l);
			maxArea = Math.max(maxArea, area);

			if (height[r] > height[l])
				l++;
			else
				r--;
		}
		return maxArea;
	}

	}
