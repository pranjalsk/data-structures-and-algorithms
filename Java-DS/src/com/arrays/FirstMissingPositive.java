package com.arrays;

public class FirstMissingPositive {

	public int firstMissingPositive(int A[], int n) {

		for (int i = 0; i < n; i++) {

			int num = A[i];
			// if number is positive and its not in its correct position
			if (num <= n && n > 0 && A[num - 1] != num) {

				// swap
				int temp = A[i];
				A[i] = A[num - 1];
				A[num - 1] = temp;

				num = A[i];
			}
		}

		for (int i = 0; i < n; i++) {
			
			if(A[i] != i+1){
				return i+1;
			}
		}
		
		return n+1;
	}

}
