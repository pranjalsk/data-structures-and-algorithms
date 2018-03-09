package com.generateCombinations;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * Given n pairs of parentheses, write a function to generate all
	 * combinations of well-formed parentheses.
	 * 
	 * For example, given n = 3, a solution set is:
	 * 
	 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
	 */
	//https://www.youtube.com/watch?v=pD2VNU2x8w8
	public List<String> generateParenthesis(int n) {

		List<String> res = new ArrayList<>();
		if (n > 0) {
			getParenthesisComb(res, "", 0, 0, n);
		}
		return res;
	}

	private void getParenthesisComb(List<String> res, String str, int open, int close, int n) {

		if (open == n && close == n) {
			res.add(str);
			return;
		} else {
			if (open < n) {
				getParenthesisComb(res, str + "(", open + 1, close, n);
			}
			if (close < open) {
				getParenthesisComb(res, str + ")", open, close + 1, n);
			}
		}
	}

}
