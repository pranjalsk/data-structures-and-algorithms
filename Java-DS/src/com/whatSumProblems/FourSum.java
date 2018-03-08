package com.whatSumProblems;

import java.util.*;

public class FourSum {

	
	/**
	 *Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

		To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
		
		Example:
		
		Input:
		A = [ 1, 2]
		B = [-2,-1]
		C = [-1, 2]
		D = [ 0, 2]
		
		Output:
		2
		
		Explanation:
		The two tuples are:
		1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
		2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
		 
	 */
	
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

		// A[i] + B[j] + C[k] + D[h] = 0
		// A[i] + B[j] == -C[k] - D[h]

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int a : A) {
			for (int b : B) {
				int sum = a + b;
				if (map.containsKey(sum)) {
					map.put(sum, map.get(sum) + 1);
				} else {
					map.put(sum, 1);
				}
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		int count = 0;
		for (int c : C) {
			for (int d : D) {
				int sum = -c - d;
				if (map.containsKey(sum)) {

					count = count + map.get(sum);
					System.out.println(sum + "--" + count);
				}

			}
		}

		return count;

	}

}
