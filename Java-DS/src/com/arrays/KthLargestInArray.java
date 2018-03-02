package com.arrays;

import java.util.*;

public class KthLargestInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int kthlargestElement(int[] nums, int k) {
		
		UniquePriorityQueue<Integer> pq = new UniquePriorityQueue<>(Collections.reverseOrder());

		int val = 0;
		for (int num : nums) {
			pq.offer(num);
		}

		while (!pq.isEmpty() && k != 0) {
			val = pq.poll();
			System.out.println(val);
			k--;
		}

		return val;
	}

}

@SuppressWarnings("serial")
class UniquePriorityQueue<E> extends PriorityQueue<E> {

	boolean isAdded = false;

	public UniquePriorityQueue(Comparator<E> comparator) {
		super(comparator);
	}

	@Override
	public boolean offer(E e) {
		if (!super.contains(e)) {
			isAdded = super.offer(e);
		}
		return isAdded;
	}

}


