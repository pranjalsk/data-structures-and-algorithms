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

	public int binarySearch(int arr[], int x) {
		int l = 0, r = arr.length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;

			if (arr[m] == x)
				return m;

			if (arr[m] < x)
				l = m + 1;
			else
				r = m - 1;
		}
		return -1;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	// -------------------

	// Merge sort
	public void mergesort(int arr[], int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			mergesort(arr, l, m);
			mergesort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}

	// ---
	void merge(int arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

}
