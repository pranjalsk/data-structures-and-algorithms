package com.dynamic;

/*You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
		Input: 3
		Output:  3
		Explanation:  There are three ways to climb to the top.

		1. 1 step + 1 step + 1 step
		2. 1 step + 2 steps
		3. 2 steps + 1 step*/

public class ClimbingStairs {

	public static int climbingStairApproach1(int n) {

		// ith staircase can be reached in ways to reach i-1 + i-2th
		int ways[] = new int[n + 1];
		if (n <= 1)
			return n;

		ways[0] = 0;
		ways[1] = 1;
		ways[2] = 2;

		// fibonnacci series for the nth number
		for (int i = 3; i <= n; i++) {
			ways[i] = ways[i - 1] + ways[i - 2];
		}

		return ways[n];
	}

	// Using fibonacci
	public static int climbingStairApproach2(int n) {
		return fibo(n + 1);
	}

	public static int fibo(int n) {
		if (n <= 1)
			return n;

		return fibo(n - 1) + fibo(n - 2);
	}
}

/*
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0
 * indexed). Once you pay the cost, you can either climb one or two steps. You
 * need to find minimum cost to reach the top of the floor, and you can either
 * start from the step with index 0, or the step with index 1. Input: cost = [1,
 * 100, 1, 1, 1, 100, 1, 1, 100, 1] Output: 6 Explanation: Cheapest is start on
 * cost[0], and only step on 1s, skipping cost[3].
 */

class ClimbingStairsCost {

	/*
	 * Bottom-Up DP Solution:
	 * Let dp[i] be the minimum cost to reach the i-th stair.
	 * Base cases:
	 * dp[0]=cost[0] dp[1]=cost[1]
	 * DP formula:
	 * dp[i]=cost[i]+min(dp[i-1],dp[i-2])
	 * Note: the top floor n can be reached from either 1 or 2 stairs away,
	 * return the minimum.
	 */
	public int minCostClimbingStairs(int[] cost) {

		int n = cost.length;
		int[] dp = new int[n];

		dp[0] = cost[0];
		dp[1] = cost[1];

		for (int i = 2; i < cost.length; i++) {
			dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
		}

		int minCostOfn = Math.min(dp[n - 1], dp[n - 2]);
		return minCostOfn;
	}

}
