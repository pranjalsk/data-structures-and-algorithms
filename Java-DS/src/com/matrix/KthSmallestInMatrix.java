package com.matrix;

import java.util.PriorityQueue;

public class KthSmallestInMatrix {

	/**
	 * Given a n x n matrix where each of the rows and columns are sorted in
	 * ascending order, find the kth smallest element in the matrix.
	 * 
	 * Note that it is the kth smallest element in the sorted order, not the kth
	 * distinct element
	 * 
	 * @param matrix
	 * @param k
	 * @return
	 */
	public int kthSmallestInMatrix(int[][] matrix, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				pq.offer(matrix[i][j]);
			}
		}
		int val = 0;
		while (!pq.isEmpty() && k != 0) {
			val = pq.poll();
			k--;
		}
		return val;
	}

}
