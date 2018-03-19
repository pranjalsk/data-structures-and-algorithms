package com.subarray;

public class MaxSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Kadane's
	public int maxSubArray(int[] A) {

		int maxCurr = A[0];
		int maxGlobal = A[0];
		int start = 0, end = 0, mstart = 0, mend = 0;

		for (int i = 1; i < A.length; i++) {

			if (A[i] > maxCurr + A[i]) {
				maxCurr = A[i];
				start = i;
				end = i;
			} else {
				maxCurr = A[i] + maxCurr;
				end = i;
			}

			if (maxGlobal < maxCurr) {
				maxGlobal = maxCurr;
				mstart = start;
				mend = end;
			}

		}
		return maxGlobal;
	}

	public static int maxSubArrayShort(int[] A) {
		int maxGlobal = A[0], maxCurr = A[0];

		for (int i = 1; i < A.length; ++i) {

			maxCurr = Math.max(maxCurr + A[i], A[i]);

			maxGlobal = Math.max(maxGlobal, maxCurr);
		}

		return maxGlobal;
	}

}
