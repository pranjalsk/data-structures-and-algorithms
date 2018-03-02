package com.arrays;

import java.util.*;
import java.util.Map.Entry;

public class ArrayOperations {

	/**
	 * Given a n x n matrix where each of the rows and columns are sorted in
	 * ascending order, find the kth smallest element in the matrix.
	 * 
	 * Note that it is the kth smallest element in the sorted order, not the kth
	 * distinct element
	 * 
	 * @param matrix
	 * @param k
	 * @return
	 */
	public int kthSmallestInMatrix(int[][] matrix, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				pq.offer(matrix[i][j]);
			}
		}
		int val = 0;
		while (!pq.isEmpty() && k != 0) {
			val = pq.poll();
			k--;
		}
		return val;
	}

	/**
	 * Given an array of n integers where n > 1, nums, return an array output
	 * such that output[i] is equal to the product of all the elements of nums
	 * except nums[i].
	 * 
	 * Solve it without division and in O(n).
	 * 
	 * For example, given [1,2,3,4], return [24,12,8,6].
	 * 
	 */
	// Brute force
	public int[] productExceptSelf(int[] nums) {

		int[] out = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			int prod = 1;

			for (int j = 0; j < nums.length; j++) {
				if (j != i) {
					prod = prod * nums[j];
				}
			}
			out[i] = prod;
		}

		return out;
	}

	// divide into left and right multi
	public int[] productExceptSelf2(int[] nums) {
		int len = nums.length;
		int[] output = new int[len];

		int leftMult = 1, rightMult = 1;

		for (int i = len - 1; i >= 0; i--) {
			output[i] = rightMult;
			rightMult *= nums[i];
		}
		for (int j = 0; j < len; j++) {
			output[j] *= leftMult;
			leftMult *= nums[j];

		}
		return output;
	}

	/**
	 * Given a non-empty array of integers, return the k most frequent elements.
	 * For example, Given [1,1,1,2,2,3] and k = 2, return [1,2]
	 * 
	 */
	public List<Integer> topKFrequent(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();
		List<Integer> out = new ArrayList<>();

		for (int num : nums) {
			if (map.containsKey(num)) {
				int val = map.get(num);
				map.put(num, val + 1);
			} else {
				map.put(num, 1);
			}
		}
		// or use this
		/*
		 * for (int num : nums) { map.put(num, map.getOrDefault(num,1)+1); }
		 */

		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(set);
		

		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		int i = 0;
		for (Entry<Integer, Integer> entry : list) {
			if (i == k)
				break;
			else {
				out.add(entry.getKey());
			}
			i++;
		}

		return out;
	}

	// 2nd largest element
	public int secondLargest(int[] A) {
		int highest = 0;
		int second_highest = 0;

		for (int n : A) {
			if (highest < n) {
				second_highest = highest;
				highest = n;

			} else if (second_highest < n) {
				second_highest = n;
			}
		}
		return second_highest;
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

	// Fibonacci Sum advanced: How many minimum numbers from fibonacci series
	// are
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

	// Find peak element in an array
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

	// Fizzbuzz
	public List<String> fizzBuzz(int n) {

		List<String> result = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				result.add("FizzBuzz");
			} else if (i % 3 == 0) {
				result.add("Fizz");
			} else if (i % 5 == 0) {
				result.add("Buzz");
			} else {
				result.add(String.valueOf(i));
			}
		}
		return result;

	}

	// Given an array of integers, every element appears twice except for one.
	// Find that single one.
	public int singleNumber(int[] nums) {
		int sum = 0;
		int hsSum = 0;
		HashSet<Integer> hs = new HashSet<>();

		for (int num : nums) {
			if (!hs.contains(num)) {
				hs.add(num);
				hsSum += num;
			}
			sum += num;
		}

		return (2 * hsSum) - sum;

		/*
		 * int result = 0; for (int i = 0; i<n; i++) { result ^=A[i]; } return*
		 * result;
		 */
	}

	// Find the Duplicate Number
	/**
	 * Given an array nums containing n + 1 integers where each integer is
	 * between 1 and n (inclusive), prove that at least one duplicate number
	 * must exist. Assume that there is only one duplicate number, find the
	 * duplicate one.
	 */
	public int findDuplicate(int[] nums) {

		HashSet<Integer> hs = new HashSet<>();
		int hssum = 0;
		int sum = 0;
		for (int num : nums) {
			if (!hs.contains(num)) {
				hs.add(num);
				hssum += num;
			}
			sum += num;
		}

		return (sum - hssum) / (nums.length - hs.size());

	}

	// ###IMP: Given an array nums, write a function to move all 0's to the end
	// of
	// it while maintaining the relative order of the non-zero elements.
	public void moveZeroes(int[] A) {
		int j = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != 0) {
				swap(A, i, j);
				j++;
			}
		}
	}

	// ##IMP: Remove Duplicates from Sorted Array
	public int removeDuplicates(int[] A) {

		int j = 0, count = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[j]) {
				j++;
				swap(A, i, j);
				count++;
			}
		}
		return count + 1; // because count represents last index
	}

	// ---------
	public void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	// Merge Sorted Array
	// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1
	// as one sorted array.
	public void mergeSortedArrays(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		while (j >= 0 && i >= 0) {
			if (nums1[i] >= nums2[j]) {
				nums1[k] = nums1[i];
				i--;
				k--;
			} else {
				nums1[k] = nums2[j];
				j--;
				k--;
			}
		}

		while (j >= 0) {
			nums1[k] = nums2[j];
			j--;
			k--;
		}

		while (i >= 0) {
			nums1[k] = nums1[i];
			i--;
			k--;
		}
	}

	// Add two numbers without +
	public int getSum(int a, int b) {
		if (a == 0)
			return b;
		if (b == 0)
			return a;

		int carry = 0;
		while (b != 0) {
			carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}

		return a;
	}

	// AB -> 28
	public int excelTitleToNumber(String s) {
		int sum = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			// System.out.println((i-(s.length()-1)));
			// System.out.println((s.charAt(i)-'A')+1);

			// Formula= CBA = (26^2 * 3) + (26^1 * 2) + (26^0 * 1)

			sum = sum + ((int) Math.pow(26, ((s.length() - 1) - i)) * ((s.charAt(i) - 'A') + 1));
		}
		return sum;

	}

	// Contains Duplicate
	// Given an array of integers, find if the array contains any duplicates.
	// Your function should return true if any value appears at least twice in
	// the array, and it should return false if every element is distinct.
	public boolean containsDuplicate(int[] nums) {

		if (nums.length == 0)
			return false;
		HashSet<Integer> hs = new HashSet<>();
		for (int num : nums) {
			if (!hs.contains(num)) {
				hs.add(num);
			}
		}
		return (hs.size() != nums.length);

		/*
		 * Arrays.sort(nums);
		 * 
		 * for(int i=1;i<nums.length;i++){ if(nums[i] == nums[i-1]){ return
		 * true; } } return false;
		 */

	}

	// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
	// find the one that is missing from the array.
	public int missingNumber(int[] nums) {
		int n = nums.length;
		int sumOfAll = (n * (n + 1)) / 2;

		int sumOfArr = 0;
		for (int num : nums) {
			sumOfArr += num;
		}
		return (sumOfAll - sumOfArr);
	}

	/*
	 * Given two arrays, write a function to compute their intersection.
	 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2]. Note:
	 * Each element in the result should appear as many times as it shows in
	 * both arrays. The result can be in any order.
	 */
	// Aprroach1
	public ArrayList<Integer> intersectApproach1(int[] nums1, int[] nums2) {
		ArrayList<Integer> result = new ArrayList<>();

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int num : nums1) {
			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				int val = map.get(num);
				map.put(num, val + 1);
			}
		}

		for (int num : nums2) {
			if (map.containsKey(num) && map.get(num) > 0) {
				result.add(num);
				int val = map.get(num);
				map.put(num, val - 1);
			}
		}
		return result;
	}

	// Appraoch2
	public ArrayList<Integer> intersectApproach2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0;
		int j = 0;
		ArrayList<Integer> result = new ArrayList<>();

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				result.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			}
		}
		return result;
	}

	// Given an integer, write a function to determine if it is a power of
	// three.
	public boolean isPowerOfThree(int n) {

		if (n == 0)
			return false;

		// check if number is completely divisible by 3
		while (n % 3 == 0) {
			n = n / 3;
		}

		if (n == 1) {
			return true;
		}
		return false;
	}

	// no. of set bits in a number
	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			count = count + (n & 1);
			n = n >>> 1;
		}
		return count;
	}

	// PLUS ONE
	// Given a non-negative integer represented as a non-empty array of digits,
	// plus one to the integer.
	public int[] plusOne(int[] digits) {

		int[] res = new int[digits.length];

		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {

			res[i] = digits[i] + carry;
			if (res[i] > 9) {
				res[i] = res[i] % 10;
				carry = 1;
			} else {
				carry = 0;
			}

		}

		if (res[0] == 0) {
			res = new int[digits.length + 1];
			res[0] = 1;
			return res;
		}

		return res;
	}

	// FACTORIAL TRAILING ZEROS
	// Given an integer n, return the number of trailing zeroes in n!.
	// count number of 5 factors in n! expansion
	public int trailingZeroes(int n) {
		int count = 0;
		while (n > 0) {
			n /= 5;
			count += n;
		}
		return count;
	}

}
