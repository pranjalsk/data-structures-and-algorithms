package com.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class ArrayOperations {

	public static void kthlargestElement(int[] arr, int k) {

	}

	public String countAndSay(int n) {
		String curr = "1";
		for (int i = 1; i < n; i++) {
			int count = 1;
			String temp = "";
			for (int j = 1; j <= curr.length(); j++) {
				if (j < curr.length() && curr.charAt(j) == curr.charAt(j - 1)) {
					count++;
				} else {
					temp = temp + String.valueOf(count) + curr.charAt(j - 1);
					count = 1;
				}
			}
			curr = temp;
		}
		return curr;
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		StringBuilder prefix = new StringBuilder();

		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (String str : strs) {
				if (str.length() < i + 1 || c != str.charAt(i)) {
					return prefix.toString();
				}
			}
			prefix.append(c);
		}
		return prefix.toString();
	}

	public int reverseInteger(int n) {
		long temp = 0;
		while (n != 0) {
			int digit = n % 10;
			temp = temp * 10 + digit;
			if (temp > Integer.MAX_VALUE)
				return 0;
			if (temp < Integer.MIN_VALUE)
				return 0;
			n = n / 10;
		}
		System.out.println(temp);
		return (int) temp;
	}

	// pattern matching - Brute force
	public int strStr(String haystack, String needle) {
		int n1 = haystack.length();
		int n2 = needle.length();

		if (n2 > n1)
			return -1;

		int i, j;

		// we iterate one step extra...note here
		for (i = 0; i <= n1 - n2; i++) {
			for (j = 0; j < n2; j++) {
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
			}
			if (j == n2)
				return i;
		}
		return -1;
	}

	// Fibonacci Sum advanced: How many minimum numbers from fibonacci series are
	// required such that sum of numbers should be equal to a given Number N
	public int fibSum(int A) {

		if (A == 0)
			return 0;
		if (A < 3)
			return 1;

		ArrayList<Integer> fib = new ArrayList<>();
		fib.add(1);
		fib.add(1);

		// get fib series upto numbers less than A
		while (A > (int) fib.get(fib.size() - 1)) {
			Integer nextNum = fib.get(fib.size() - 1) + fib.get(fib.size() - 2);
			fib.add(nextNum);
		}

		int count = 0;

		// traverse fib series from back and keep subtracting A each time until
		// you get 0
		while (A != 0) {
			// trim all the end elementd greater than A
			while ((int) fib.get(fib.size() - 1) > A) {
				fib.remove(fib.size() - 1);
			}
			A = A - fib.get(fib.size() - 1);
			count++;
		}
		return count;
	}

	
	//Find peak element in an array
	public int getPeakElement(int[] arr) {

		if (arr == null || arr.length == 0)
			return 0;

		int n = arr.length;
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {

			int mid = (start + end) / 2;

			if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == n - 1 || arr[mid] >= arr[mid + 1])) {
				return arr[mid];
			} else if (mid > 0 && arr[mid - 1] > arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}
		return 0;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
