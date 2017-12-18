import java.util.Arrays;

public class InsertionSort {

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

	public static void main(String[] args) {
		int[] array = { 12, 35, 87, 26, 9, 28, 7 };
		insertionSort(array);
		System.out.println("Sorted array: " + Arrays.toString(array));
	}

}
