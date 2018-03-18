package com.backtracking;

import java.util.*;

/**
 *  Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

 */
public class PermutationsOfArray {

	// Backtracking approach
	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> tempList = new ArrayList<>();
		permuteBacktrack(result, tempList, nums);
		return result;
	}

	private void permuteBacktrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {

		if (tempList.size() != nums.length) {

			for (int i = 0; i < nums.length; i++) {

				if (tempList.contains(nums[i]))
					continue;

				tempList.add(nums[i]);
				permuteBacktrack(result, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		} else {
			result.add(new ArrayList<>(tempList));
		}

	}

}
