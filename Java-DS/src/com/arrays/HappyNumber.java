package com.arrays;

import java.util.HashSet;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Write an algorithm to determine if a number is "happy".
	 * 
	 * A happy number is a number defined by the following process: Starting
	 * with any positive integer, replace the number by the sum of the squares
	 * of its digits, and repeat the process until the number equals 1 (where it
	 * will stay), or it loops endlessly in a cycle which does not include 1.
	 * Those numbers for which this process ends in 1 are happy numbers.
	 * 
	 * Example: 19 is a happy number
	 * 
	 * 12 + 92 = 82 ;82 + 22 = 68 ;62 + 82 = 100 ;12 + 02 + 02 = 1
	 * 
	 */

	public boolean isHappy(int n) {
		if (n == 1)
			return true;

		HashSet<Integer> hs = new HashSet<>();
		hs.add(n);

		while (n != 1) {
			int temp = getSum(n);
			if (hs.contains(temp)) {
				return false;
			} else {
				hs.add(temp);
			}
			n = temp;
		}

		return true;

	}

	public int getSum(int n) {

		int sum = 0;
		while (n != 0) {
			int temp = n % 10;
			sum = sum + (temp * temp);
			n = n / 10;
		}
		return sum;
	}

}
