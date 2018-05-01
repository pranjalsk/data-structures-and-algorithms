package com.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SlidingWindowProblems {

	// All anagrams
	/*
	 * Given a string s and a non-empty string p, find all the start indices of
	 * p's anagrams in s.
	 * 
	 * Strings consists of lowercase English letters only and the length of both
	 * strings s and p will not be larger than 20,100.
	 * 
	 * The order of output does not matter. Input: s: "cbaebabacd" p: "abc"
	 * 
	 * Output: [0, 6]
	 */
	public List<Integer> findAnagrams(String s, String p) {

		List<Integer> result = new ArrayList<Integer>();

		// Sliding window
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char c : p.toCharArray()){
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		int begin = 0; int end = 0;
		int counter = map.size();
		
		while(end < s.length()){
			
			char c = s.charAt(end);
			
			if(map.containsKey(c)){
				map.put(c, map.get(c)-1);
				if(map.get(c) == 0){
					counter--;
				}
			}
			end++;
			
			//all letters are exhausted then counter == 0
			while(counter == 0){

				if(end-begin == p.length()){
					result.add(begin);
				}
				
				//move begin ahead
				char b = s.charAt(begin);
				if(map.containsKey(b)){
					map.put(b, map.get(b)+1);
					if(map.get(b) > 0){
						counter++;
					}
				}
				begin++;
			}
				
		}
		return result;
	}

}
