package com.strings;

/**
 * An edit between two strings is one of the following changes.
 * 
 * Add a character Delete a character Change a character
 * 
 * Given two string s1 and s2, find if s1 can be converted to s2 with exactly
 * one edit. Expected time complexity is O(m+n) where m and n are lengths of two
 * strings.
 * 
 * 
 */

public class OneAway {

	public static void main(String[] args) {

		OneAway o = new OneAway();

		System.out.println(o.oneEditAway("pale", "ple"));
		System.out.println(o.oneEditAway("pales", "pale"));
		System.out.println(o.oneEditAway("pale", "bale"));
		System.out.println(o.oneEditAway("pale", "bae"));

	}

	public boolean oneEditAway(String s1, String s2) {
		if (s1.length() == s2.length())
			return oneEditReplace(s1, s2);
		else if (s1.length() > s2.length())
			return oneEditInsert(s1, s2);
		else if (s2.length() > s1.length())
			return oneEditInsert(s2, s1);

		return false;
	}

	private boolean oneEditInsert(String s1, String s2) {

		int i = 0;
		int j = 0;
		while (i < s1.length() && j < s2.length()) {

			if (s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			} else {
				i++;
				if (s1.charAt(i) != s2.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean oneEditReplace(String s1, String s2) {
		int diffCount = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				diffCount++;
		}
		return (diffCount == 1);
	}

}
