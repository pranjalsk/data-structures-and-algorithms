package com.dynamic;

public class Driver {

	public static void main(String[] args) {
		
		Subsequences.longestCommonSubsequence("abcdaf", "acbcf");
	
		Subsequences.longestCommonSubstring("abcdaf", "zbcdf");
		
		//System.out.println(Subsequences.longestNonrepeatingSubstring("pwwkew"));
		//System.out.println(Subsequences.longestNonrepeatingSubstring("abcabcbb"));
		//System.out.println(Subsequences.longestNonrepeatingSubstring("bbbbb"));
		
		Subsequences.longestIncreasingSubsequence(new int []{0,4,12,2,10,6,9,13,3,11,7,15});
		
	}

}
