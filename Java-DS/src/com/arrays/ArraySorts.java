package com.arrays;

public class ArraySorts {
	public static void insertionSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return;
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return;
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			if (arr[i] != arr[minIndex]) {
				swap(arr, i, minIndex);
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	
	
	
	
}
