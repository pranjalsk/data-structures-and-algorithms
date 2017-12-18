//Find peak element in an array
public class PeakElement {

	public static int getPeakElement(int[] arr) {

		if (arr == null || arr.length == 0)
			return 0;

		int n = arr.length;
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {

			int mid = (start + end) / 2;

			if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == n - 1 || arr[mid] >= arr[mid + 1])) {
				return arr[mid];
			} else if (mid > 0 && arr[mid - 1] > arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}
		return 0;

	}

	public static void main(String[] args) {
		int[] array = { 15, 20, 95, 35, 45, 50, 60 };
		int peak = getPeakElement(array);
		System.out.println(peak != 0 ? "Peak Element is " + peak : "No peak element!");
	}
}
