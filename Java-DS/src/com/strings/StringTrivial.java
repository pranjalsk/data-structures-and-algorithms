package com.strings;

/*
 * https://www.geeksforgeeks.org/counting-number-lines-words-characters-paragraphs-text-file-using-java/
 * https://www.geeksforgeeks.org/searching-for-character-and-substring-in-a-string/
 * https://www.geeksforgeeks.org/swap-two-strings-without-using-third-user-defined-variable-in-java/
 * https://www.geeksforgeeks.org/remove-trailing-zeros-string-java/
 * 
 */

public class StringTrivial {

	// Reverse characters of one string
	public String reverseString(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	// reverse all words in a string array
	/**
	 * Given s = "the sky is blue", return "blue is sky the".
	 */
	public String reverseWords(String s) {

		String[] strArr = s.trim().split("\\s+");
		StringBuilder out = new StringBuilder();
		for (int i = strArr.length - 1; i >= 0; i--) {
			out.append(strArr[i]).append(" ");
		}
		return out.toString().trim();
	}

	public String reverseWordsWithSpaces(String s) {

		String[] strArr = s.split("\\s+");
		StringBuilder out = new StringBuilder();
		int n = s.length();
		int count = strArr.length - 1;
		for (int i = n - 1; i >= 0;) {
			if (s.charAt(i) == ' ') {
				out.append(" ");
				i--;
			} else {
				out.append(strArr[count]);
				i = i - strArr[count].length();
				count--;
			}
		}
		return out.toString();
	}

	// ------------Reverse each word---------------------------------------
	public void reverse(char[] s, int l, int r) {
		while (l < r) {
			char temp = s[l];
			s[l] = s[r];
			s[r] = temp;
			l++;
			r--;
		}
	}

	public String reverseWordsInSentence(String s) {
		char[] strArr = s.toCharArray();
		int i = 0;
		for (int j = 0; j < strArr.length; j++) {
			if (strArr[j] == ' ') {
				reverse(strArr, i, j - 1);
				i = j + 1;
			}
		}
		reverse(strArr, i, strArr.length - 1);
		return new String(strArr);
	}

	public boolean isAnagram(String s, String t) {

		int[] stg = new int[26];

		for (int i = 0; i < s.length(); i++) {
			stg[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < t.length(); i++) {
			stg[t.charAt(i) - 'a']--;
		}

		for (int i = 0; i < stg.length; i++) {
			if (stg[i] != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Given a string, find the first non-repeating character in it and return
	 * it's index. If it doesn't exist, return -1.
	 * 
	 * s = "loveleetcode", return 2.
	 */
	public int firstUniqChar(String s) {

		int[] stg = new int[26];

		for (int i = 0; i < s.length(); i++) {
			stg[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			if (stg[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}

	// Longest common prefix
	// Write a function to find the longest common prefix string amongst an
	// array of strings.
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

	public boolean isPalindrome(String str) {
		if (str.isEmpty()) {
			return true;
		}
		String s = str.toLowerCase();

		int i = 0;
		int j = s.length() - 1;
		char[] A = s.toCharArray();

		while (i <= j) {

			if (!Character.isLetterOrDigit(A[i])) {
				i++;
			}
			else if (!Character.isLetterOrDigit(A[j])) {
				j--;
			} 
			else {
				if (A[i] != A[j]) {
					return false;
				}
				i++;
				j--;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		StringTrivial ops = new StringTrivial();
		System.out.println(ops.reverseWordsWithSpaces("the sky     is blue"));
		System.out.println(ops.reverseWordsInSentence("the sky     is blue"));

	}
}
