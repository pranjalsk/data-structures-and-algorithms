package com.dynamic;

import java.util.Arrays;

/*
 * Coin change problem
 * 0/1 knapsack
 * subset sum
 * rod cutting
 * job scheduling
 */

public class DynamicProblems {

	// coin change problem
	// *Must watch: https://www.youtube.com/watch?v=jaNZ83Q3QGc
	//recrursion way: https://www.youtube.com/watch?v=k4y5Pr0YVhg
	public static int minCombinationsCoins(int[] coins, int amount) {

		int[] combArr = new int[amount + 1];

		combArr[0] = 1;

		for (int coin : coins) {
			for (int amt = 1; amt < combArr.length; amt++) {
				if (amt >= coin) {
					combArr[amt] = combArr[amt] + combArr[amt - coin];
				}
			}
		}

		for (int i = 0; i < combArr.length; i++) {
			System.out.print(" " + combArr[i]);
		}

		System.out.println(" coin " + combArr[amount]);

		return combArr[amount];
	}

}
