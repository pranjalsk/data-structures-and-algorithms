package com.permutations;

import java.util.HashMap;

/**
 * Given a string, determine if a permutation of the string could form a
 * palindrome.
 * 
 * For example, "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class PalimdromePermutations {

	/**
	 * Logic: If a string with an even length is a palindrome, every character
	 * in the string must always occur an even number of times. If the string
	 * with an odd length is a palindrome, every character except one of the
	 * characters must always occur an even number of times. Thus, in case of a
	 * palindrome, the number of characters with odd number of occurences can't
	 * exceed 1(1 in case of odd length and 0 in case of even length).
	 */
	public boolean canPermutePalindrome(String s) {

		//to ignore char case and whitespace
		//s = s.toLowerCase().trim().replaceAll("\\s+", "");
		
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			Character key = s.charAt(i);
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		//to print map
//		for(Map.Entry<Character, Integer> entry : map.entrySet())
//			System.out.println(entry.getKey() + "--" + entry.getValue());
			
		int countOdds = 0;
		for (Character key : map.keySet()) {
			int val = map.get(key);
			if (val % 2 != 0) // if it is not even
				countOdds++;
		}

		return (countOdds <= 1);
	}

	
	public static void main(String[] args) {
		
		PalimdromePermutations p = new PalimdromePermutations();
		
		System.out.println(p.canPermutePalindrome("code"));
		System.out.println(p.canPermutePalindrome("aab"));
		System.out.println(p.canPermutePalindrome("carerac"));
		System.out.println(p.canPermutePalindrome("Tact Coa")); //we are considering Char Case and whitespaces too
		
	}
}
