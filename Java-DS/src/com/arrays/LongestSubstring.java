package com.arrays;

public class LongestSubstring {

	// Naive O(n3)
	public static String getLongestSubstringNonRepeatingCharsNaive(String str) {
		String longestSubstring = "";
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				if (hasRepeatingChar(str, i, j)) {
					break;
				} else if ((longestSubstring.length() - 1) < (j - i)) {
					longestSubstring = str.substring(i, j + 1);
				}
			}
		}
		return longestSubstring;
	}

	public static boolean hasRepeatingChar(String str, int s, int e) {
		boolean charArr[] = new boolean[256];
		for (int i = s; i <= e; i++) {
			if (charArr[str.charAt(i)]) {
				return true;
			} else {
				charArr[str.charAt(i)] = true;
			}
		}
		return false;
	}

	// Approach 2 - O(n)
	public static String getLongestSubstringNonRepeatingChars(String str) {
		if (str == null) {
			return null;
		}

		int n = str.length();
		if (n < 2) {
			return str;
		}

		int[] charArr = new int[256];
		for (int i = 0; i < 256; i++) {
			charArr[i] = -1;
		}

		charArr[str.charAt(0)] = 0;

		int currLength = 1;
		int maxLength = 1;
		int prevInd = 0;
		int startInd = 0;

		for (int i = 0; i < str.length(); i++) {

			prevInd = charArr[str.charAt(i)];

			if (prevInd == -1 || prevInd < i - currLength) {
				currLength++;
			} else {
				if (currLength > maxLength) {
					maxLength = currLength;
					startInd = i - maxLength;
				}
				currLength = i - prevInd;
			}

			charArr[str.charAt(i)] = i;

		}

		if (currLength > maxLength) {
			maxLength = currLength;
			startInd = str.length() - maxLength;
		}

		return str.substring(startInd, startInd + maxLength);
	}

	public static void main(String[] args) {
		String str = "ABCDABDEFGCABD";
		/*
		 * String longestSubstring =
		 * getLongestSubstringNonRepeatingCharsNaive(str); System.out.println(
		 * "Longest substring non repeating chars by Naive method:\t\t" +
		 * longestSubstring);
		 */
		String longestSubstring = getLongestSubstringNonRepeatingChars(str);
		System.out.println("Longest substring non repeating chars by linear time method:\t" + longestSubstring);

	}
}
