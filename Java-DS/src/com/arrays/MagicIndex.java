package com.arrays;

public class MagicIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//https://codesolutiony.wordpress.com/2016/09/20/leetcode-ransom-note/
		
	}
	
//https://gist.github.com/WOLOHAHA/c84b0b54b9448457e99f
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
//	public int findMagicIndexDuplicates(int[] num) {
//		return subFind(num, 0, num.length - 1);
//	}

//	private int subFind(int[] num, int start, int end) {
//	    int result = -1;
//	    if (start > end) {
//	        return -1;
//	    }
//	    int mid = (start + end) / 2;
//	    if (num[mid] == mid) {
//	        return mid;
//	    }
//	    if (num[mid] > mid) {
//	        result = subFind(num, start, mid - 1) == -1 ? result = subFind(num, num[mid], end);
//	    } else {
//	        result = subFind(num, mid + 1, end) == -1 ? subFind(num, start, num[mid]);
//	    }
//	    return result;
//	}

}
