package com.whatSumProblems;

import java.util.*;

public class ThreeSum {

	/**
	 * 3 SUM ZERO
	 * 
	 * Given an array S of n integers, are there elements a, b, c in S such that
	 * a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 * 
	 * Note: The solution set must not contain duplicate triplets.
	 * 
	 * For example, given array S = [-1, 0, 1, 2, -1, -4],
	 * 
	 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
	 * 
	 */
	public List<List<Integer>> threeSum(int[] A) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int n = A.length;

		if (A.length < 3)
			return result;

		Arrays.sort(A);

		for (int i = 0; i < n - 2; i++) {

			if (i == 0 || A[i] > A[i - 1]) {

				int start = i + 1;
				int end = n - 1;

				while (start < end) {

					int sum = A[i] + A[start] + A[end];

					if (sum == 0) {

						List<Integer> inner = new ArrayList<Integer>();
						inner.add(A[i]);
						inner.add(A[start]);
						inner.add(A[end]);
						result.add(inner);

						int currentStart = start;
						int currentEnd = end;

						while (A[start] == A[currentStart] && start < end) {
							start++;
						}

						while (A[end] == A[currentEnd] && start < end) {
							end--;
						}

					}

					else if (sum < 0) {
						int currentStart = start;
						while (A[start] == A[currentStart] && start < end) {
							start++;
						}
					}

					else {
						int currentEnd = end;
						while (A[end] == A[currentEnd] && start < end) {
							end--;
						}
					}
				}
			}
		}
		return result;

	}

	/**
	 * 3 SUM CLOSEST
	 * 
	 * Given an array S of n integers, find three integers in S such that the
	 * sum is closest to a given number, target. Return the sum of the three
	 * integers. You may assume that each input would have exactly one solution.
	 * 
	 * For example, given array S = {-1 2 1 -4}, and target = 1.
	 * 
	 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 * 
	 */
	public int threeSumClosest(int[] A, int target) {
		Arrays.sort(A);

		int minSum = A[0] + A[1] + A[A.length - 1];
		int minDistance = Math.abs(minSum - target);

		for (int i = 0; i < A.length - 2; i++) {

			int start = i + 1;
			int end = A.length - 1;

			while (start < end) {
				int sum = A[i] + A[start] + A[end];
				if (sum < target) {
					start++;
				} else {
					end--;
				}

				int dist = Math.abs(sum - target);
				if (dist < minDistance) {
					minDistance = dist;
					minSum = sum;
				}
			}

		}
		return minSum;

	}
}
