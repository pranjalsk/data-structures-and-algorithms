package com.arrays;

public class MagicIndex {

	public static void main(String[] args) {
	
	}

	// https://codesolutiony.wordpress.com/2016/09/20/leetcode-ransom-note/
	/**
	 * A magic index in an arrayA[l…n-l]is defined to be index so that A[i] = i.
	 * Given a sorted array of distinct integers, write a method to find a magic
	 * index, if one exists, in array A.
	 */
	public int findMagicIndex(int[] num) {
		int start = 0, end = num.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (num[mid] == mid) {
				return mid;
			}
			if (num[mid] > mid) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	// What if the values are not distinct?
	public int getMagicIndexFollowup(int[] array, int start, int end) {
		if (end < start || end > array.length - 1 || start < 0)
			return -1;
		int midIndex = (end - start) / 2 + start;
		int midValue = array[midIndex];
		if (midIndex == midValue)
			return midIndex;
		// search left
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = getMagicIndexFollowup(array, start, leftIndex);
		if (left >= 0)
			return left;
		// search right
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = getMagicIndexFollowup(array, rightIndex, end);
		return right;
	}

}
