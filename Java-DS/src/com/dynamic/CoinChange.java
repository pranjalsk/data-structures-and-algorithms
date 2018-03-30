package com.dynamic;

import java.util.Arrays;

/*
 * Coin change problem
 * subset sum
 * rod cutting
 * job scheduling
 */

public class CoinChange {

	// coin change problem
	// *Must watch: https://www.youtube.com/watch?v=jaNZ83Q3QGc
	//recursion way: https://www.youtube.com/watch?v=k4y5Pr0YVhg
	  public int coinChange(int[] coins, int amount) {
	        int [] combination = new int[amount + 1];
	        int [] minComb = new int[amount + 1];
	        
	        Arrays.fill(minComb, Integer.MAX_VALUE-1);
	        
			combination[0] = 1;
			minComb[0] = 0;
			for (int coin : coins) {
				for (int amt = 1; amt < combination.length; amt++) {
					if (amt >= coin) {
						combination[amt] = combination[amt] + combination[amt - coin];
	                    minComb[amt] = Math.min(minComb[amt], minComb[amt-coin]+1);
					}
				}
			}

			//return combination[amount];
			return minComb[amount] > amount ? -1 : minComb[amount];
	    }

}
