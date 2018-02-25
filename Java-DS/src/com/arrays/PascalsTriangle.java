package com.arrays;

import java.util.*;

public class PascalsTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Given numRows, generate the first numRows of Pascal's triangle.
	 * 
	 * For example, given numRows = 5, Return
	 * 
	 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
	 * 
	 * @param numRows
	 * @return
	 */

	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> result = new ArrayList<>();

		if (numRows == 0)
			return result;

		List<Integer> prev = new ArrayList<>();
		prev.add(1);

		if (numRows == 1) {
			result.add(prev);
			return result;
		} else {
			result.add(prev);
			int n = numRows - 1;
			while (n != 0) {
				List<Integer> curr = new ArrayList<>();
				
				curr.add(1);
				
				for (int i = 0; i < prev.size() - 1; i++) {
					int res = (prev.get(i) + prev.get(i + 1));
					curr.add(res);
				}
				
				curr.add(1);
				
				result.add(curr);
				prev = curr;
				n--;
			}

		}

		return result;
	}

}
