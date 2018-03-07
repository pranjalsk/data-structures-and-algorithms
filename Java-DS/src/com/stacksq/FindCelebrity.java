package com.stacksq;

import java.util.Stack;

/**
Credits:https://www.geeksforgeeks.org/the-celebrity-problem/
 * Suppose you are at a party with n people (labeled from 0 to n – 1) and among
 * them, there may exist one celebrity. The definition of a celebrity is that
 * all the other n – 1 people know him/her but he/she does not know any of them.
 * 
 * Now you want to find out who the celebrity is or verify that there is not
 * one. The only thing you are allowed to do is to ask questions like: “Hi, A.
 * Do you know B?” to get information of whether A knows B. You need to find out
 * the celebrity (or verify there is not one) by asking as few questions as
 * possible (in the asymptotic sense).
 * 
 * You are given a helper function bool knows(a, b) which tells you whether A
 * knows B. Implement a function int findCelebrity(n), your function should
 * minimize the number of calls to knows.
 * 
 * Note: There will be exactly one celebrity if he/she is in the party. Return
 * the celebrity’s label if there is a celebrity in the party. If there is no
 * celebrity, return -1.
 */

public class FindCelebrity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
        int result = findCelebrity(n);
        if (result == -1) 
        {
            System.out.println("No Celebrity");
        } 
        else
            System.out.println("Celebrity ID " + result);

	}

	static int MATRIX[][] = { { 1, 0, 1, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };

	// Returns true if a knows b, false otherwise
	static boolean knows(int a, int b) {
		boolean res = (MATRIX[a][b] == 1) ? true : false;
		return res;
	}

	/**
	 * We can use stack to verify celebrity.
	 * 
	 * Push all the celebrities into a stack. Pop off top two persons from the
	 * stack, discard one person based on return status of HaveAcquaintance(A,
	 * B). Push the remained person onto stack. Repeat step 2 and 3 until only
	 * one person remains in the stack. Check the remained person in stack
	 * doesn’t have acquaintance with anyone else.
	 * 
	 */
	static int findCelebrity(int n) {

		Stack<Integer> stack = new Stack<>();

		// push every person on stack
		for (int i = 0; i < n; i++) {
			stack.push(i);
		}

		while (stack.size() > 1) {
			int a = stack.pop();
			int b = stack.pop();

			if (knows(a, b))
				stack.push(b);
			else
				stack.push(a);
		}

		int celeb = stack.pop();

		// check if celeb candidate is celeb or not
		for (int i = 0; i < n; i++) {
			if (i != celeb && (knows(celeb, i) || !knows(i, celeb))) {
				return -1;
			}
		}

		return celeb;
	}

}
