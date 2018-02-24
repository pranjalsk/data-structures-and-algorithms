package com.arrays;

public class UglyNumbers {

	// https://www.geeksforgeeks.org/ugly-numbers/
	public static void main(String[] args) {
		UglyNumbers ops = new UglyNumbers();
		System.out.println(ops.nthUglyNumber(15));
	}

	public int nthUglyNumber(int n) {
		int i = 1;
		int count = 1;
		while (count < n) {
			i++;
			if (isUgly(i)) {
				count++;
			}
		}
		return i;
	}

	public boolean isUgly(int num) {
		if (num <= 0)
			return false;
		while (num % 2 == 0)
			num /= 2;
		while (num % 3 == 0)
			num /= 3;
		while (num % 5 == 0)
			num /= 5;
		return num == 1;
	}

}
