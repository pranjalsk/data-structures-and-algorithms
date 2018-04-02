package com.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

/*
Longest Common Subsequence
Longest common substring
Longest Increasing Subsequence
Longest palindromic subsequence
Longest palimdromic substring
*/

public class Subsequences {

	public static void longestCommonSubsequence(String a, String b) {
		char[] A = a.toCharArray();
		char[] B = b.toCharArray();

		// if char matches, select diagonally previous
		// if dosen't match, select max between top and left
		int[][] dp = new int[A.length + 1][B.length + 1];

		ArrayList<Character> lcs = new ArrayList<>();
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < A.length + 1; i++) {
			for (int j = 0; j < B.length + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					// add to list
					if (dp[i][j] > max) {
						max = dp[i][j];
						lcs.add(A[i - 1]);
					}
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		System.out.println("Max length of LCS: " + dp[A.length][B.length]);

		StringBuilder result = new StringBuilder(lcs.size());
		for (Character c : lcs) {
			result.append(c);
		}
		System.out.println("LCS is: " + result.toString());
	}

	// Longest common substring--------------------------------------
	public static void longestCommonSubstring(String a, String b) {
		char[] A = a.toCharArray();
		char[] B = b.toCharArray();

		int[][] dp = new int[A.length + 1][B.length + 1];
		String substr = "";
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < A.length + 1; i++) {
			for (int j = 0; j < B.length + 1; j++) {

				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;

					if (dp[i][j] > max) {
						max = dp[i][j];
						substr = a.substring(i - max, i);
					}
				} else {
					dp[i][j] = 0;
				}
			}
		}

		System.out.println("Max substring length:" + max);
		System.out.println("Substring is: " + substr);
	}

	

	// ----------------------------------------------------
	// Longest increasing subsequence
	/*
	 * Given [10, 9, 2, 5, 3, 7, 101, 18],The longest increasing subsequence is
	 * [2, 3, 7, 101], therefore the length is 4. Note that there may be more
	 * than one LIS combination, it is only necessary for you to return the
	 * length
	 */
	public static void longestIncreasingSubsequence(int[] A) {

		int n = A.length;
		int[] dp = new int[A.length];
		Arrays.fill(dp, 1);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println("Max inc subseq length: " + dp[dp.length - 1]);
	}

	// Longest palindromic substring
	public String longestPalindromeSubstring(String s) {
		String out = "";
		int n = s.length();
		// for odd length palimdromic strings;
		for (int i = 0; i < n; i++) {
			for (int j = 0; i + j < n && i - j >= 0; j++) {
				if (s.charAt(i + j) != s.charAt(i - j)) {
					break;
				} else {
					String substr = s.substring(i - j, (i + j) + 1);
					if (substr.length() > out.length()) {
						out = substr;
					}
				}
			}
		}
		// for even length palimdromic substrings
		for (int i = 0; i < n; i++) {
			for (int j = 0; i - j >= 0 && i + j + 1 < n; j++) {
				if (s.charAt(i) == s.charAt(i + 1)) { //to check if adjecent is same
					if (s.charAt(i + j + 1) != s.charAt(i - j)) {
						break;
					} else {
						String substr = s.substring(i - j, (i + j + 1) + 1);
						if (substr.length() > out.length()) {
							out = substr;
						}
					}
				}
			}
		}
		return out;
	}

	
	//longest palimdromic subsequence
	
	
}
