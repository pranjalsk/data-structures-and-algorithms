package com.matrix;

public class GameOfLife {

	public void gameOfLife(int board[][]) {

		if (board == null || board.length == 0)
			return;

		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				int liveCellAround = getNumbLiveNeighbors(board, i, j, m, n);

				if (board[i][j] == 0) {
					// we may convert to 1 if...
					if (liveCellAround == 3) {
						// yes we convert it to 1...but for now lets set it to 2
						board[i][j] = 2;
					}
				} else if (board[i][j] == 1) {
					// we may convert it to 0 if...
					if (liveCellAround < 2 || liveCellAround > 3) {
						// yes we convert 1 to 0..but for now let set it to 3
						board[i][j] = 3;
					}
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (board[i][j] == 2) {
					board[i][j] = 1;
				} else if (board[i][j] == 3) {
					board[i][j] = 0;
				}

			}
		}

	}

	private int getNumbLiveNeighbors(int board[][], int currRow, int currCol, int m, int n) {
		int count = 0;
		for (int i = currRow - 1; i <= currRow + 1; i++) {
			for (int j = currCol - 1; j <= currCol + 1; j++) {
				if (i >= 0 && i < m && j >= 0 && j < n) {
					if (board[i][j] == 1 || board[i][j] == 3) {
						count++;
					}
				}
			}
		}

		if (board[currRow][currCol] == 1 || board[currRow][currCol] == 3)
			count--;

		return count;
	}

}
