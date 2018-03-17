package com.wordProblems;

/**
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {

		int m = board.length;
		int n = board[0].length;

		int pos = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (board[i][j] == word.charAt(0)) {

					if (dfs(board, i, j, m, n, 0, word)) {
						return true;
					}

				}
			}
		}

		return false;
	}

	public boolean dfs(char[][] board, int i, int j, int m, int n, int pos, String word) {

		if (pos == word.length())
			return true;

		if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(pos)) {
			return false;
		}

		char record = board[i][j];
		board[i][j] = '1'; // mark visited

		boolean res = (dfs(board, i - 1, j, m, n, pos + 1, word) || dfs(board, i, j - 1, m, n, pos + 1, word)
				|| dfs(board, i, j + 1, m, n, pos + 1, word) || dfs(board, i + 1, j, m, n, pos + 1, word));

		board[i][j] = record;
		return res;
	}
}

class WordSearchChiraag {
	public boolean exist(char[][] board, String word) {
		int row = board.length;
		int col = board[0].length;
		int pos = 0;
		boolean found = false;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == word.charAt(pos)) {
					if (pos == word.length() - 1) {
						return true;
					}
					found = check(board, i, j, row, col, pos + 1, word);
					if (found == true) {
						break;
					}
				}

			}
			if (found) {
				break;
			}
		}
		return found;
	}

	public boolean check(char[][] board, int i, int j, int row, int col, int pos, String word) {
		char left, right, top, bottom;
		boolean found = false;
		board[i][j] ^= 256;
		// left
		if (j - 1 >= 0 && board[i][j - 1] == word.charAt(pos)) {
			if (pos == word.length() - 1) {
				return true;
			}
			found = check(board, i, j - 1, row, col, pos + 1, word);
		}
		// right
		if (!found && j + 1 < col && board[i][j + 1] == word.charAt(pos)) {
			if (pos == word.length() - 1) {
				return true;
			}
			found = check(board, i, j + 1, row, col, pos + 1, word);
		}
		// top
		if (!found && i - 1 >= 0 && board[i - 1][j] == word.charAt(pos)) {
			if (pos == word.length() - 1) {
				return true;
			}
			found = check(board, i - 1, j, row, col, pos + 1, word);
		}
		// bottom
		if (!found && i + 1 < row && board[i + 1][j] == word.charAt(pos)) {
			if (pos == word.length() - 1) {
				return true;
			}
			found = check(board, i + 1, j, row, col, pos + 1, word);
		}
		board[i][j] ^= 256;
		return found;
	}

}