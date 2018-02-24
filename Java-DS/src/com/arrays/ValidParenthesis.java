package com.arrays;

import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("{([])}([])"));

	}

	public static boolean isValid(String s) {

		if (s == "")
			return true;

		Stack<Character> stk = new Stack<>();

		char[] arr = s.toCharArray();

		for (char c : arr) {

			if (c == '(') {
				stk.push('(');
			} else if (c == '{') {
				stk.push('{');
			} else if (c == '[') {
				stk.push('[');
			} else if (c == ')') {
				if (stk.isEmpty() || stk.pop() != '(') {
					return false;
				}
			} else if (c == '}') {
				if (stk.isEmpty() || stk.pop() != '{') {
					return false;
				}
			} else if (c == ']') {
				if (stk.isEmpty() || stk.pop() != '[') {
					return false;
				}
			}
		}

		return stk.isEmpty();
	}

	// without using stack
	/*public boolean isValid(String s) {
		while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
			s = s.replace("()", "");
			s = s.replace("[]", "");
			s = s.replace("{}", "");
		}
		if (s.length() == 0)
			return true;
		else
			return false;
	}*/

}
