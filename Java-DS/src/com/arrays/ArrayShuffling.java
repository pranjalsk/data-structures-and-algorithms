package com.arrays;

import java.util.Random;

/**
 * The Fisher-Yates algorithm is remarkably similar to the brute force solution.
 * On each iteration of the algorithm, we generate a random integer between the
 * current index and the last index of the array. Then, we swap the elements at
 * the current index and the chosen index - this simulates drawing (and
 * removing) the element from the hat, as the next range from which we select a
 * random index will not include the most recently processed one. One small, yet
 * important detail is that it is possible to swap an element with itself -
 * otherwise, some array permutations would be more likely than others.
 */
public class ArrayShuffling {

	private int [] array;
	private int [] clonedCopy;
	
	Random random = new Random();
	
	public ArrayShuffling(int[] nums) {
        array = nums;
        clonedCopy = nums.clone();
    }
	
	private int getRandomBound(int i, int j){
		return random.nextInt(j-i)+i;
	}
	
	private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
	
	public int[] reset() {
        array = clonedCopy;
        clonedCopy = clonedCopy.clone();
        return clonedCopy;
    }
	
	public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, getRandomBound(i, array.length));
        }
        return array;
    }
}
