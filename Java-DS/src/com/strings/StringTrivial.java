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
				i -= strArr[count].length();
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

	public static void main(String[] args) {

		StringTrivial ops = new StringTrivial();
		System.out.println(ops.reverseWordsWithSpaces("the sky     is blue"));
		System.out.println(ops.reverseWordsInSentence("the sky     is blue"));

	}
}
