package com.strings;

/**
 * Given an array of characters, compress it in-place.
 * 
 * The length after compression must always be smaller than or equal to the
 * original array.
 * 
 * Every element of the array should be a character (not int) of length 1.
 * 
 * After you are done modifying the input array in-place, return the new length
 * of the array.
 * 
 * Follow up: Could you solve it using only O(1) extra space?
 */
public class StrCompression {

	public static String compress(String s) {

		int len = s.length();
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		for (int i = 0; i < len; i++) {
			if (i != len - 1 && s.charAt(i) == s.charAt(i + 1)) {
				cnt++;
			} else {
				sb.append(s.charAt(i));
				sb.append(cnt);
				cnt = 1;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		System.out.println(compress("abbbccc"));

	}
}
