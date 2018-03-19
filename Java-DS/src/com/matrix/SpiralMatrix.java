package com.matrix;

import java.util.*;

public class SpiralMatrix {

	public static void main(String[] args) {

		SpiralMatrix o = new SpiralMatrix();

		int[][] matrix = { { 2, 3 } };

		System.out.println(o.spiralOrder(matrix));

		int[][] mat = o.generateSpiralMatrix(4);
		for (int[] row : mat) {
			for (int i : row)
				System.out.print(i + "\t");
			System.out.println();
		}
	}

	
	/**
	 Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
	
	For example,
	Given the following matrix:
	
	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
	
	You should return [1,2,3,6,9,8,7,4,5]. 
	 
	 
	 */
	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return res;
		int top = 0;
		int bottom = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;

		while (top <= bottom && left <= right) {

			for (int i = left; i <= right; i++) {
				res.add(matrix[top][i]);
			}
			top++;

			for (int i = top; i <= bottom; i++) {
				res.add(matrix[i][right]);
			}
			right--;

			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					res.add(matrix[bottom][i]);
				}
			}
			bottom--;

			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					res.add(matrix[i][left]);
				}
			}
			left++;
		}

		return res;

	}

	/**
	 *Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
		
		For example,
		Given n = 3,
		You should return the following matrix:
		
		[
		 [ 1, 2, 3 ],
		 [ 8, 9, 4 ],
		 [ 7, 6, 5 ]
		]
		 
	 */
	public int[][] generateSpiralMatrix(int n) {
		int[][] res = new int[n][n];

		if (n == 0)
			return res;

		int top = 0;
		int bottom = n - 1;
		int left = 0;
		int right = n - 1;
		int counter = 1;

		while (top <= bottom && left <= right) {
			for (int i = left; i <= right; i++) {
				res[top][i] = counter++;
			}
			top++;

			// top to bottom
			for (int i = top; i <= bottom; i++) {
				res[i][right] = counter++;
			}
			right--;

			// right to left
			for (int i = right; i >= left; i--) {
				res[bottom][i] = counter++;
			}
			bottom--;

			// from bottom to top
			for (int i = bottom; i >= top; i--) {
				res[i][left] = counter++;
			}
			left++;
		}
		return res;

	}

}
