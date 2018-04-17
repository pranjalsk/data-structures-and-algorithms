package com.linkedlist;

public class MergeKSortedLists {


	//divide and conquere merge sort approach
	//imagine each list as individual array element like you would see in array
	//use same logic as merge sort
	public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }
	
	private ListNode sort(ListNode [] lists, int l, int h){
		
		if(l < h){
			
			int mid = l + (h-l)/2;

			ListNode l1 = sort(lists, l, mid);
			ListNode l2 = sort(lists, mid+1, h);
			
			return merge(l1, l2);
		}
		else{
			return lists[l];
		}
		
	}

	private ListNode merge(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		
		while(l1 != null && l2 != null){
			
			if(l1.val < l2.val){
				curr.next = l1;
				curr = curr.next;
				l1 = l1.next;
			}
			else{
				curr.next = l2;
				curr = curr.next;
				l2 = l2.next;
			}
		}
		while(l1 != null){
			curr.next = l1;
			l1 = l1.next;
			curr = curr.next;
		}
		while(l2 != null){
			curr.next = l2;
			l2 = l2.next;
			curr = curr.next;
		}
		return dummy.next;	
	}
	
}

