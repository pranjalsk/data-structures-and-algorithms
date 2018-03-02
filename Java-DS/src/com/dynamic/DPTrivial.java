package com.dynamic;

public class DPTrivial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static void towerOfHanoi(int n, String source, String auxiliary, String destination) {
		if (n == 0)
			return;
		towerOfHanoi(n - 1, source, destination, auxiliary);
		System.out.println("Disc " + n + " moved from source " + source + " to destination " + destination);
		towerOfHanoi(n - 1, auxiliary, source, destination);
	}

	private static int fib(int n) {
		if (n == 0 || n == 1)
			return 1;
		return fib(n - 1) + fib(n - 2);

	}

	private static void fibDP(int n) {
		int[] F = new int[n + 1];
		F[0] = 0;
		F[1] = 1;
		for (int i = 2; i <= n; i++) {
			F[i] = F[i - 1] + F[i - 2];
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(F[i] + " ");
		}
	}

	private static int factorial(int num) {
		if (num == 0)
			return 0;
		else if (num == 1)
			return 1;
		else
			return num * factorial(num - 1);
	}

	private static void factorialDP(int num) {
		int[] F = new int[num + 1];
		F[0] = 0;
		F[1] = 1;
		for (int i = 2; i <= num; i++) {
			F[i] = i * F[i - 1];
		}
		System.out.print(F[num]);
	}

	private static int GCD(int a, int b) {
		if (a == 0)
			return b;
		return GCD(b % a, a);
	}

	private static int Division(int num1, int num2) {
		if (num1 < num2) {
			return 0;
		} else {
			return 1 + Division(num1 - num2, num2);
		}
	}

	private static int Multiplication(int a, int b) {
		if (b > 0) {
			return a + Multiplication(a, b - 1);
		} else {
			return 0;
		}
	}

	private static int Power(int a, int b) {
		if (b > 0) {
			return Multiplication(a, Power(a, b - 1));
		} else {
			return 1;
		}
	}

}
