package com.dynamic;

import java.util.Arrays;

/*Write a function to return the minimum number of jumps to reach the end of the array 
(starting from the first element). If an element is 0, then cannot move through that element.
*/
public class MinJumps {

	// https://www.youtube.com/watch?v=jH_5ypQggWg
	public int jump(int[] A) {

		int n = A.length;
		int[] minJumpArr = new int[n];

		Arrays.fill(minJumpArr, Integer.MAX_VALUE - 1);

		minJumpArr[0] = 0;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (i <= j + A[j]) {
					minJumpArr[i] = Math.min(minJumpArr[i], minJumpArr[j] + 1);
					break;
				}
			}
		}

		return minJumpArr[n - 1];
	}
}

