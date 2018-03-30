package com.arrays;

import java.util.Arrays;

public class WiggleSort {

	/**
	 * Given an unsorted array nums, reorder it in-place such that nums[0] <=
	 * nums[1] >= nums[2] <= nums[3]....
	 * 
	 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1,
	 * 6, 2, 5, 3, 4]
	 */
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length - 1; i = i + 2) {
			swap(nums, i, i + 1);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	// Aprr 2
	/**
	 * This can be done in O(n) time by doing a single traversal of given array.
	 * The idea is based on the fact that if we make sure that all even
	 * positioned (at index 0, 2, 4, ..) elements are greater than their
	 * adjacent odd elements, we don’t need to worry about odd positioned
	 * element. Following are simple steps. 
	 * 1) Traverse all even positioned
	 * elements of input array, and do following. ….a) If current element is
	 * smaller than previous odd element, swap previous and current. ….b) If
	 * current element is smaller than next odd element, swap next and current.
	 * 
	 * @param arr
	 */
	public void wiggleSort2(int[] arr) {

		int n = arr.length;

		// Traverse all even elements
		for (int i = 0; i < n; i += 2) {

			// If current even element is smaller
			// than previous
			if (i > 0 && arr[i - 1] > arr[i])
				swap(arr, i - 1, i);

			// If current even element is smaller
			// than next
			if (i < n - 1 && arr[i] < arr[i + 1])
				swap(arr, i, i + 1);
		}
	}

}
