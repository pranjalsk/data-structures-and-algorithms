package com.matrix;

public class MatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void setZeroes(int[][] matrix) {

		int nrow = matrix.length;
		int ncol = matrix[0].length;

		boolean[] rowStg = new boolean[matrix.length];
		boolean[] colStg = new boolean[matrix[0].length];

		for (int i = 0; i < nrow; i++) {
			for (int j = 0; j < ncol; j++) {
				if (matrix[i][j] == 0) {
					rowStg[i] = true;
					colStg[j] = true;
				}
			}
		}

		for (int i = 0; i < rowStg.length; i++) {
			if (rowStg[i] == true) {
				for (int j = 0; j < ncol; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int j = 0; j < colStg.length; j++) {
			if (colStg[j] == true) {
				for (int i = 0; i < nrow; i++) {
					matrix[i][j] = 0;
				}
			}
		}

	}
}
