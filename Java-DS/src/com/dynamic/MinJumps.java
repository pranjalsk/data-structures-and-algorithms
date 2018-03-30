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


	// Jump game
	/**
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Determine if you are able to reach the last index.
	 * 
	 * For example: A = [2,3,1,1,4], return true.
	 * 
	 * A = [3,2,1,0,4], return false.
	 */

	public boolean canJump(int[] A) {
		
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

		if(minJumpArr[n-1] == Integer.MAX_VALUE - 1)
            return false;
        
        return true;
  
	}
	
	
}