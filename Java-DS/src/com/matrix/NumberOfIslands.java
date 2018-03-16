package com.matrix;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 11110 
 * 11010 
 * 11000 
 * 00000
 * 
 * Answer: 1
 * 
 * Example 2:
 * 
 * 11000 
 * 11000 
 * 00100 
 * 00011
 * 
 * Answer: 3
 */
public class NumberOfIslands {

	public int numIslands(char[][] grid) {

		if (grid.length == 0 || grid == null)
			return 0;
		// start with the 1st cell
		// check if its 1
		// recursively clear off all its neighbors
		int m = grid.length;
		int n = grid[0].length;
		int count = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (grid[i][j] == '1') {
					count++;
					clearOff(grid, i, j, m, n);
				}

			}
		}
		return count;
	}

	public void clearOff(char grid[][], int i, int j, int m, int n) {

		if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == '1') {
			grid[i][j] = '0';
		} else {
			return;
		}
		clearOff(grid, i + 1, j, m, n);
		clearOff(grid, i - 1, j, m, n);
		clearOff(grid, i, j + 1, m, n);
		clearOff(grid, i, j - 1, m, n);
	}
}


/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]

Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.

Example 2:

[[0,0,0,0,0,0,0,0]]

Given the above grid, return 0. 
 */
class MaxAreaIsland {
	public int maxAreaOfIsland(int[][] grid) {

		if (grid.length == 0 || grid == null)
			return 0;

		int m = grid.length;
		int n = grid[0].length;
		int max = 0;

		int currArea[] = new int[1]; // i am using array we want pass by
										// reference, other wise our area wont
										// be added up
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					currArea[0] = 0;
					clearOff(grid, i, j, m, n, currArea);
					// System.out.println(currArea[0]);
					max = Math.max(max, currArea[0]);
				}
			}
		}
		return max;
	}

	public void clearOff(int grid[][], int i, int j, int m, int n, int[] currArea) {

		if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
			currArea[0]++;
			grid[i][j] = 0;
		} else {
			return;
		}
		clearOff(grid, i + 1, j, m, n, currArea);
		clearOff(grid, i - 1, j, m, n, currArea);
		clearOff(grid, i, j + 1, m, n, currArea);
		clearOff(grid, i, j - 1, m, n, currArea);
	}
}


//max perimeter of an island