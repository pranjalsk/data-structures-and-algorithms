package com.dynamic;

import java.util.Arrays;

/*
 * Coin change problem
 * subset sum
 * rod cutting
 * job scheduling
 */

public class DynamicProblems {

	// coin change problem
	// *Must watch: https://www.youtube.com/watch?v=jaNZ83Q3QGc
	//recursion way: https://www.youtube.com/watch?v=k4y5Pr0YVhg
	public static int minCombinationsCoins(int[] coins, int amount) {

		int[] combination = new int[amount + 1];

		combination[0] = 1;

		for (int coin : coins) {
			for (int amt = 1; amt < combination.length; amt++) {
				if (amt >= coin) {
					combination[amt] = combination[amt] + combination[amt - coin];
				}
			}
		}

		for (int i = 0; i < combination.length; i++) {
			System.out.print(" " + combination[i]);
		}

		System.out.println(" coin " + combination[amount]);

		return combination[amount];
	}

}
