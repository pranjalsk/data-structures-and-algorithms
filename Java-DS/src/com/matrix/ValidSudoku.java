package com.matrix;

import java.util.HashSet;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {

		for (int i = 0; i < 9; i++) {
			HashSet<Integer> row = new HashSet<>();
			HashSet<Integer> col = new HashSet<>();
			HashSet<Integer> grid = new HashSet<>();
			for (int j = 0; j < 9; j++) {

				if (board[i][j] != '.') {
					int num1 = Integer.valueOf(board[i][j]);
					if (row.contains(num1))
						return false;
					else
						row.add(num1);
				}

				if (board[j][i] != '.') {
					int num2 = Integer.valueOf(board[j][i]);
					if (col.contains(num2))
						return false;
					else
						col.add(num2);
				}

				int cubeRow = 3 * (i / 3) + j / 3;
				int cubeCol = 3 * (i % 3) + j % 3;
				if (board[cubeRow][cubeCol] != '.') {
					int num3 = Integer.valueOf(board[cubeRow][cubeCol]);
					if (grid.contains(num3))
						return false;
					else
						grid.add(num3);
				}

			}
		}

		return true;

	}

}
