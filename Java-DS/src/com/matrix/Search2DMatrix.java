package com.matrix;

public class Search2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted in ascending from left to right. Integers
	 * in each column are sorted in ascending from top to bottom.
	 * 
	 * For example,
	 * 
	 * Consider the following matrix:
	 * 
	 * [ [1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14,
	 * 17, 24], [18, 21, 23, 26, 30] ]
	 * 
	 * Given target = 5, return true.
	 * 
	 * Given target = 20, return false.
	 */

	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
			return false;
		}

		int col = matrix[0].length - 1;
		int row = 0;

		while (row < matrix.length && col >= 0) {

			if (target == matrix[row][col])
				return true;

			else if (target > matrix[row][col])
				row++;
			else if (target < matrix[row][col])
				col--;
		}
		return false;
	}

	/**
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted from left to right. The first integer of
	 * each row is greater than the last integer of the previous row.
	 * 
	 * For example,
	 * 
	 * Consider the following matrix:
	 * 
	 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ]
	 * 
	 * Given target = 3, return true.
	 * 
	 */

	public boolean searchMatrix2(int[][] matrix, int target) {

		int m = matrix.length;
		int n = matrix[0].length;

		int start = 0, end = m * n - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			int mid_value = matrix[mid / n][mid % n];

			if (mid_value == target)
				return true;

			else if (mid_value < target)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return false;
	}

}
