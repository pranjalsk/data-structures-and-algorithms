package com.strings;

import java.util.HashSet;

public class LongestSubstringNonRepeat {

	// BETTER APPROACH -- Sliding window
	public static String longestNonrepeatingSubstringBetter(String str) {

		int n = str.length();
		HashSet<Character> set = new HashSet<>();
		String longestSub = "";

		int i = 0, j = 0;
		while (i < n && j < n) {

			// move j further right until its not in set
			if (!set.contains(str.charAt(j))) {
				set.add(str.charAt(j));

				if ((longestSub.length() - 1) < (j - i))
					longestSub = str.substring(i, j + 1);

				j++;

			} else {
				set.remove(str.charAt(i));
				i++;
			}

		}

		System.out.println(longestSub);
		return longestSub;
	}

	// BRUTE FORCE------------------
	// Longest Substring without repeating characters
	// e.g.Given "pwwkew", the answer is "wke", with the length of 3. Note that
	// answer must be a substring, "pwke" is a subsequence and not a substring.
	// Brute force - find all substring and check if they are unique
	public static String longestNonrepeatingSubstring(String str) {
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
		HashSet<Character> hs = new HashSet<>();
		for (int i = s; i <= e; i++) {
			if (hs.contains(str.charAt(i))) {
				return true;
			}
			hs.add(str.charAt(i));
		}
		return false;
	}

	public static void main(String[] args) {
		String str = "ABCDABDEFGCABD";
		/*
		 * String longestSubstring =
		 * getLongestSubstringNonRepeatingCharsNaive(str); System.out.println(
		 * "Longest substring non repeating chars by Naive method:\t\t" +
		 * longestSubstring);
		 */
		String longestSubstring = longestNonrepeatingSubstringBetter(str);
		System.out.println("Longest substring non repeating chars by linear time method:\t" + longestSubstring);

	}
}
