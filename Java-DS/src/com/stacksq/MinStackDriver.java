package com.stacksq;

import java.util.Stack;

class MinStackNode {
	int value;
	int min;

	public MinStackNode(int v) {
		value = v;
		min = Integer.MAX_VALUE;
	}
}

class MinStack1 {

	// Approach 1
	// Keep a minimum class variable
	// When minimum is popped it has to search for new min

	int min;
	int count = 0;
	int size;
	int[] stack = new int[size];

	public MinStack1(int n) {
		size = n;
	}

	public void push(int elem) {
		if (isFull()) {
			System.out.println("Stack overflow");
		} else {
			stack[count++] = elem;
			if (elem < min)
				min = elem;
		}
	}

	public void pop() {
		if (isEmpty()) {
			System.out.println("Stack empty");
		} else {
			if (stack[count] == min) {
				for (int i = 0; i <= count; i++) {
					if (stack[i] < min)
						min = stack[i];
				}
			} else
				stack[count--] = 0;
		}
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack empty");
			return 0;
		} else {
			return stack[count];
		}
	}

	public boolean isFull() {
		if (count == size)
			return true;
		else
			return false;
	}

	public boolean isEmpty() {
		if (count == 0)
			return true;
		else
			return false;
	}

	public int min() {
		return min;
	}

	//Approach 2

	//Maintain minimum for	every element
	/*int count = 0;
	int size;
	MinStackNode stack[];

	public MinStack(int n) {
		size = n;
		stack = new MinStackNode[size];
	}

	public void push(MinStackNode elem) {
		if (isFull()) {
			System.out.println("Stack overflow");
		} else {
			if (isEmpty() || elem.value < peek()) {
				elem.min = elem.value;
				stack[count] = elem;
				count++;
			} else {
				elem.min = peek();
				stack[count++] = elem;

			}

		}
	}

	public void pop() {
		if (isEmpty()) {
			System.out.println("Stack empty");
		} else {
			stack[count--] = null;
		}
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack empty");
			return 0;
		} else {
			return stack[count - 1].min;
		}
	}

	public boolean isFull() {
		if (count == size)
			return true;
		else
			return false;
	}

	public boolean isEmpty() {
		if (count == 0)
			return true;
		else
			return false;
	}

	public int min() {
		System.out.println(stack[count - 1].min);
		return stack[count - 1].min;
	}

	public void display() {
		for (int i = 0; i < count; i++) {
			System.out.print(" " + stack[i].value);
		}
		System.out.println();
	}*/

}

// Approach 3
// maintain a separate stack for minimum

class MinStack extends Stack<Integer> {
	Stack<Integer> s2 = new Stack<Integer>();

	public void push(int value) {
		if (value <= min())
			s2.push(value);
		super.push(value);
	}

	public Integer pop() {
		if (super.isEmpty()) {
			System.out.println("Stack is empty");
			return Integer.MAX_VALUE;
		} else {
			if (super.peek() <= s2.peek())
				s2.pop();
			return super.pop();

		}

	}

	public int min() {
		if (super.isEmpty()) {

			// System.out.println(Integer.MAX_VALUE);
			return Integer.MAX_VALUE;
		} else {
			// System.out.println(s2.peek());
			return s2.peek();
		}
	}

	public void display() {
		// Object []stack = super.toArray();
		for (int i = 0; i < super.size(); i++) {
			System.out.print(" " + super.elementAt(i));
		}
		System.out.println();
		// Object []st2 = s2.toArray();
		for (int i = 0; i < s2.size(); i++) {
			System.out.print(" " + s2.elementAt(i));
		}
		System.out.println();
	}
}

public class MinStackDriver {
	public static void main(String[] args) {

		// Test approach 2
		// MinStack ob = new MinStack(10);
		// ob.push (new MinStackNode(5));
		// ob.display();
		// ob.min();
		// ob.push (new MinStackNode(6));
		// ob.display();
		// ob.min();
		// ob.push (new MinStackNode(3));
		// ob.display();
		// ob.min();
		// ob.push (new MinStackNode(8));
		// ob.display();
		// ob.min();
		// ob.pop();
		// ob.display();
		// ob.min();
		// ob.pop();
		// ob.display();
		// ob.min();
		// ob.pop();
		// ob.display();
		// ob.min();
		// ob.pop();
		// ob.display();
		// ob.min();

		// test approach 3

		MinStack ob = new MinStack();
		ob.push(5);
		ob.display();
		ob.push(6);
		ob.display();
		ob.push(8);
		ob.display();
		ob.push(7);
		ob.display();
		ob.push(3);
		ob.display();
		ob.pop();
		ob.display();
		ob.pop();
		ob.display();
		// ob.min();
	}
}
