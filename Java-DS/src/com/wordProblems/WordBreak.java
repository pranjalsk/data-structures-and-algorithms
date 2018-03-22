package com.wordProblems;

import java.util.*;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words. You may assume the dictionary does
 * not contain duplicate words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {

		if (s.length() == 0) {
			return true;
		}

		for (int i = 1; i < s.length() + 1; i++) {  //we go one step extra because substring is exclusive
			String substr = s.substring(0, i);
			System.out.println("Substr is: " + substr);
			boolean isPresent = isPresent(substr, wordDict);

			if (isPresent) {
				boolean result = wordBreak(s.substring(i), wordDict);
				if (result) {
					return true;
				}
			}

		}
		return false;

	}

	private boolean isPresent(String substr, List<String> wordDict) {
		HashSet<String> set = new HashSet<>(wordDict);
		return set.contains(substr);
	}

	public static void main(String[] args) {

		String[] dict = { "leet", "code" };
		List<String> arr = new ArrayList<>(Arrays.asList(dict));

		System.out.println(new WordBreak().wordBreak("leetherocode", arr));

	}

}
