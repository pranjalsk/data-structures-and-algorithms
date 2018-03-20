package com.stacksq;

import java.util.ArrayDeque;

public class PostfixOrReversePolish {

	/**
	 * 
	 * 
	 * Evaluate the value of an arithmetic expression in Reverse Polish
	 * Notation.
	 * 
	 * Valid operators are +, -, *, /. Each operand may be an integer or another
	 * expression. Examples:
	 * 
	 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", "5", "/",*
	 * "+"] -> (4 + (13 / 5)) -> 6
	 */
	public int evalRPN(String[] tokens) {

		ArrayDeque<Integer> stack = new ArrayDeque<>();

		for (String token : tokens) {

			if (token.equals("+")) {
				Integer op2 = stack.pop();
				Integer op1 = stack.pop();
				stack.push(op2 + op1);
			} else if (token.equals("-")) {
				Integer op2 = stack.pop();
				Integer op1 = stack.pop();
				stack.push(op1 - op2);
			} else if (token.equals("*")) {
				Integer op2 = stack.pop();
				Integer op1 = stack.pop();
				stack.push(op2 * op1);
			} else if (token.equals("/")) {
				Integer op2 = stack.pop();
				Integer op1 = stack.pop();
				stack.push(op1 / op2);
			} else {
				stack.push(Integer.parseInt(token));
			}

		}
		return stack.peek();

	}

}
