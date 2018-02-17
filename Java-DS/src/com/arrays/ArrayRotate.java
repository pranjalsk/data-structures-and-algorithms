package com.arrays;

import java.util.Arrays;

public class ArrayRotate {

	// Approach 1 -- Brute Force
	private static void rotateArrayNaive(int[] array, int k) {
		if (k < 0) {
			throw new IllegalArgumentException("k cannot be negative!");
		}
		if (array == null || array.length < 2) {
			return;
		}
		int n = array.length;
		if (k > n) {
			k = k % n;
		}
		for (int i = 0; i < k; i++) {
			rotateArrayOnce(array);
		}
	}

	private static void rotateArrayOnce(int[] array) {
		int temp = array[0];
		for (int i = 0; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		array[array.length - 1] = temp;
	}

	// ----------------------------------------------
	// Approach 2 -Using Temp Array
	private static void rotateArrayUsingTmp(int[] array, int k) {

		if (k < 0) {
			throw new IllegalArgumentException("k cannot be negative!");
		}
		if (array == null || array.length < 2) {
			return;
		}

		int n = array.length;
		if (k > n)
			k = k % n;

		int[] tempArr = new int[k];
		// step1:copy first k elements to temp arr
		for (int i = 0; i < k; i++) {
			tempArr[i] = array[i];
		}
		// Step2: shift k to end of arr elements to begining of arr
		for (int i = k; i < n - 1; i++) {
			array[i - k] = array[k];
		}
		// Step3: copy temp array elements to end of array
		for (int i = n - k, j = 0; i < n; i++, j++) {
			array[i] = tempArr[j];
		}
	}
	
	
	//Approach 3 - Using Array Reverse
	private static void rotateArrayUsingReverse(int[] array, int k) {
		if(k < 0) {
            throw new IllegalArgumentException("k cannot be negative!");
        }
         
        if(array == null || array.length < 2) {
            return;
        }
 
        int n = array.length;
        if(k > n)
            k = k%n;
		
        //step 1: reverse array 0 to k-1
        reverseArray(array,0,k-1);
        //step 2: reverse array k to n-1
        reverseArray(array,k,n-1);
        //step 3: reverse whole array
        reverseArray(array,0,n-1);             
	}

	private static void reverseArray(int[] array, int start, int end) {
		while(start<end){
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start ++;
			end --;
		}		
	}

	// -----------------
	public static void main(String[] args) {
		testArrayRotationNaive();
		testArrayRotationTmp();
		testArrayRotationReverse();
	}

	private static void testArrayRotationNaive() {
		int[] array = { 1, 2, 3, 4, 5 };
		int k = 8;
		System.out.println("Original Array: ");
		System.out.println(Arrays.toString(array));
		rotateArrayNaive(array, k);
		System.out.println("After Rotation " + k + " times using naive algorithm: ");
		System.out.println(Arrays.toString(array));
	}

	private static void testArrayRotationTmp() {
		int[] array = { 1, 2, 3, 4, 5 };
		int k = 8;
		System.out.println("Original Array: ");
		System.out.println(Arrays.toString(array));
		rotateArrayUsingTmp(array, k);
		System.out.println("After Rotation " + k + " times using temporary array: ");
		System.out.println(Arrays.toString(array));
	}

	private static void testArrayRotationReverse() {
		int[] array = { 1, 2, 3, 4, 5 };
		int k = 8;
		System.out.println("Original Array: ");
		System.out.println(Arrays.toString(array));
		rotateArrayUsingReverse(array, k);
		System.out.println("After Rotation " + k + " times using reversal: ");
		System.out.println(Arrays.toString(array));
	}


}
