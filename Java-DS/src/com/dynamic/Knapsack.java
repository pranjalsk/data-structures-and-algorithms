package com.dynamic;

import java.util.Arrays;

/*
 * Naive recursive
 * DP = recursive + memoized
 * Bottom up / iterative 
 */
public class Knapsack {

	static int itemCount = 6;
	static int capacity = 10;

	// int [] v = new int []{0,60,100,120};
	int[] w = new int[] { -1, 6, 1, 2, 5, 4, 3 };
	int[] v = new int[] { -1, 10, 5, 7, 12, 8, 6 };
	// int [] w = new int []{0,10,20,30};

	static int[][] dp = new int[itemCount + 1][capacity + 1];

	public static void main(String[] args) {
		System.out.println("Max benefit is: " + new Knapsack().KS(itemCount, capacity));

		for (int[] row : dp)
			Arrays.fill(row, -1);

		System.out.println("Max benefit is: " + new Knapsack().KSDP(itemCount, capacity));

	}

	// Naive recursive
	public int KS(int i, int c) {
		// base case
		if (i == 0 || c == 0)
			return 0;

		if (w[i] > c)
			return KS(i - 1, c);

		else {
			int temp1 = KS(i - 1, c); // NO case
			int temp2 = v[i] + KS(i - 1, c - w[i]); // YES case
			int result = Math.max(temp1, temp2);
			return result;
		}
	}

	// DP = recursion + memoization
	public int KSDP(int i, int c) {
		if (dp[i][c] != -1)
			return dp[i][c];

		// base case
		if (i == 0 || c == 0)
			return 0;

		if (w[i] > c)
			return KSDP(i - 1, c);

		else {
			int temp1 = KSDP(i - 1, c); // NO case
			int temp2 = v[i] + KSDP(i - 1, c - w[i]); // YES case
			int result = Math.max(temp1, temp2);
			dp[i][c] = result;
			return result;
		}
	}

}
