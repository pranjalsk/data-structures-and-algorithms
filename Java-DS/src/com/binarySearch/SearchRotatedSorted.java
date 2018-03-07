package com.binarySearch;

public class SearchRotatedSorted {

	public int search(int[] A, int target) {
	    int left = 0;
	    int right = A.length - 1;
	    
	    while (left <= right) {
	        
	    	int mid = left + (right - left) / 2;
	        
	    	if (A[mid] == target)
	            return mid;
	         
	    	
	    	else if (A[mid] > target) {
	            // the left half is monotonic, yet still does not satisfy
	            if (A[left] <= A[mid] && A[left] > target) { 
	                left = mid + 1;
	            } else {
	                right = mid - 1;
	            }
	        } else {
	            // the right half is monotonic, yet still does not satisfy
	            if (A[right] >= A[mid] && A[right] < target) { 
	                right = mid - 1;
	            } else {
	                left = mid + 1;
	            }
	        }
	    }
	    return -1;
	}
}
