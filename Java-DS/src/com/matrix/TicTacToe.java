package com.matrix;

public class TicTacToe {

	public static void main(String[] args) {
		
		
		

	}

	int[][] game;

	public TicTacToe(int n) {
		game = new int[n][n];
	}

	public int move(int row, int col, int player) {

		game[row][col] = player;
		int n = game.length;

		// check col
		boolean win = true;
		for (int i = 0; i < n; i++) {
			if (game[row][i] != player) {
				win = false;
				break;
			}
		}
		if (win)
			return player;

		// check row
		win = true;
		for (int i = 0; i < n; i++) {
			if (game[i][col] != player) {
				win = false;
				break;
			}
		}
		if (win)
			return player;

		// check diagonal 1
		win = true;
		for (int i = 0; i < n; i++) {
			if (game[i][i] != player) {
				win = false;
				break;
			}
		}
		if (win)
			return player;

		// check diagonal 2
		win = true;
		for (int i = 0; i < n; i++) {
			if (game[i][n - 1 - i] != player) {
				win = false;
				break;
			}
		}
		if (win)
			return player;

		return 0;
	}

}
