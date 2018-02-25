package com.arrays;

public class StockPrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times). However, you may not engage in multiple transactions at
	 * the same time (ie, you must sell the stock before you buy again).
	 */
	public int maxProfit(int[] A) {
		if (A.length < 2)
			return 0;

		int profit = 0;

		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i - 1]) {
				profit = profit + (A[i] - A[i - 1]);
			}
		}
		return profit;
	}

	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * If you were only permitted to complete at most one transaction (ie, buy
	 * one and sell one share of the stock), design an algorithm to find the
	 * maximum profit.
	 */
	public int maxProfitSingleTransact(int[] prices) {

		if (prices.length < 2)
			return 0;
		
		int minEle = prices[0];
		int maxDiff = prices[1] - prices[0];

		for (int i = 1; i < prices.length; i++) {

			maxDiff = Math.max(0, Math.max(maxDiff, prices[i] - minEle));

			minEle = Math.min(minEle, prices[i]);
		}
		return maxDiff;
	}

}
