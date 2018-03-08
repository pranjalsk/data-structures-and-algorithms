package com.whatSumProblems;

import java.util.*;

/**
 * If you have already read and implement the 3sum and 4sum by using the sorting
 * approach: reduce them into 2sum at the end, you might already got the feeling
 * that, all ksum problem can be divided into two problems:
 * 
 * 2sum Problem Reduce K sum problem to K – 1 sum Problem
 * 
 */
public class KSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		int len = nums.length;
		Arrays.sort(nums);
		return kSum(nums, target, 4, 0, len);
	}

	private ArrayList<List<Integer>> kSum(int[] A, int target, int k, int index, int len) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if (index >= len) {
			return res;
		}

		if (k == 2) {

			int i = index, j = len;
			while (i < j) {

				int sum = A[i] + A[j];
				if (target - sum == 0) {

					List<Integer> temp = new ArrayList<>();
					temp.add(A[i]);
					temp.add(A[j]);
					res.add(temp);

					// skip duplicates
					while (A[i] == A[i + 1] && i < j)
						i++;

					while (A[j] == A[j - 1] && j > i)
						j--;

					i++;
					j--;
				} else if (sum < target) {
					i++;
				} else {
					j--;
				}

			}

		} else {
			for (int i = index; i < len - k + 1; i++) {
				// use current number to reduce ksum into k-1sum
				ArrayList<List<Integer>> temp = kSum(A, target - A[i], k - 1, i + 1,len);
				if (temp != null) {
					// add previous results
					for (List<Integer> t : temp) {
						t.add(0, A[i]);
					}
					res.addAll(temp);
				}
				while (i < len - 1 && A[i] == A[i + 1]) {
					// skip duplicated numbers
					i++;
				}
			}
		}
		return res;

	}

}
