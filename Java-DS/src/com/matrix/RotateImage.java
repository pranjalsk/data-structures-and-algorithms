package com.matrix;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * You are given an n x n 2D matrix representing an image.
	 * 
	 * Rotate the image by 90 degrees (clockwise).
	 * 
	 * Note: You have to rotate the image in-place, which means you have to
	 * modify the input 2D matrix directly. DO NOT allocate another 2D matrix
	 * and do the rotation.
	 * 
		Example 1:
		
		Given input matrix = 
		[
		  [1,2,3],
		  [4,5,6],
		  [7,8,9]
		],
		
		rotate the input matrix in-place such that it becomes:
		[
		  [7,4,1],
		  [8,5,2],
		  [9,6,3]
		]

	 * 
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {

		int m = matrix.length;
		int n = matrix[0].length;

		// transpose the matrix
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// reverse each row
		for (int i = 0; i < m; i++) {
			int j = 0, k = n - 1;

			while (j < k) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][k];
				matrix[i][k] = temp;
				j++;
				k--;
			}
		}
	}

}
