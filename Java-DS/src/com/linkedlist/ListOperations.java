package com.linkedlist;

public class ListOperations {

	ListNode head = null;

	public ListOperations() {
		head = null;
	}

	public void add(ListNode node) {
		if (head == null)
			head = node;
		else {
			ListNode curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = node;
		}
	}

	public void display() {
		if (head == null)
			System.out.println("Empty");
		else {
			ListNode curr = head;
			while (curr != null) {
				System.out.print(curr.val + " ");
				curr = curr.next;
			}
		}
	}

	public void showList(ListNode head) {
		if (head == null)
			System.out.println("Empty");
		else {
			ListNode curr = head;
			while (curr != null) {
				System.out.print(curr.val + " ");
				curr = curr.next;
			}
		}
	}

	public int getSize() {
		int size = 0;
		if (head == null)
			return size;
		else {
			ListNode curr = head;
			while (curr != null) {
				size++;
				curr = curr.next;
			}
		}
		return size;
	}

	// sorting----------------MERGE SORT-------------------------------
	public void sortedList() {
		ListNode temp = head;
		ListNode curr = sortList(temp);
		// print
		showList(curr);
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		// find med
		ListNode prev = null, slow = head, fast = head;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		// now slow pointing to mid
		// cut the list into halves
		prev.next = null;

		// sort each half
		ListNode left = sortList(head);
		ListNode right = sortList(slow);

		// merge list
		return merge(left, right);

	}

	public ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while (left != null && right != null) {
			if (left.val < right.val) {
				curr.next = left;
				left = left.next;
				curr = curr.next;
			} else {
				curr.next = right;
				right = right.next;
				curr = curr.next;
			}
		}
		while (left != null) {
			curr.next = left;
			left = left.next;
			curr = curr.next;
		}
		while (right != null) {
			curr.next = right;
			right = right.next;
			curr = curr.next;
		}
		return dummy.next;
	}

	// ---------------------Delete Node--------------------
	// Deleting value
	public void delNode(int del) {
		// ListNode temp = delete(del);
		ListNode temp = deletePos(0);
		showList(temp);
	}

	public ListNode delete(int delval) {
		if (head == null) {
			return head;
		} else if (head.val == delval) {
			head = head.next;
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy, curr = head;
		while (curr != null) {
			if (curr.val == delval) {
				prev.next = curr.next;
				break; // remove break if you want to delete all duplicates
			}
			prev = curr;
			curr = curr.next;
		}
		return dummy.next;
	}

	public ListNode deletePos(int pos) {
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy, curr = head;
		int index = 1;
		while (curr != null) {
			if (index == pos) {
				prev.next = curr.next;
				break;
			}
			index++;
			prev = curr;
			curr = curr.next;
		}
		return dummy.next;
	}

	// ---------------------------Reverse-----------------------------
	public ListNode reverseList(ListNode head) {
		ListNode prev = null, nextNode = null, curr = head;
		while (curr != null) {
			nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;
		}
		head = prev;
		return head;
	}

	// intersection of two lists
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode p1 = headA, p2 = headB;
		int len1 = 0, len2 = 0;
		while (p1 != null) {
			p1 = p1.next;
			len1++;
		}
		while (p2 != null) {
			p2 = p2.next;
			len2++;
		}
		p1 = headA;
		p2 = headB;
		if (len1 > len2) {
			for (int i = 0; i < len1 - len2; i++) {
				p1 = p1.next;
			}
		} else {
			for (int i = 0; i < len2 - len1; i++) {
				p2 = p2.next;
			}
		}
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	// Detect cycle----------------------------
	public boolean hasCycle(ListNode head) {

		if (head == null)
			return false;
		if (head.next == null)
			return false;

		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false; // no loop
	}

	public ListNode detectAndRemove(ListNode head) {

		if (head == null)
			return head;
		if (head.next == null)
			return head;

		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		if (slow == fast) {
			slow = head;
			// move both pointer at equal speed
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			// fast.next and slow.next points to intersection point
			// disconnect it
			fast.next = null;
		}

		return head;
	}

	// ----Palindrome of list---------
	public boolean ispalim() {
		return isPalindrome(head);
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		// find mid point
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode newHead;
		// now slow points to midpoint
		if (fast == null) { // even case
			newHead = slow;
		} else {
			newHead = slow.next;
		}

		ListNode revHead = reverseList(newHead);

		ListNode ptr1 = head;
		ListNode ptr2 = revHead;

		while (ptr2 != null) {
			if (ptr1.val != ptr2.val) {
				return false;
			}
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		return true;
	}

	/*
	 * Add two lists of non neg integers Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode head = new ListNode(0);
		ListNode p = head;

		int tempSum = 0;
		while (l1 != null || l2 != null || tempSum != 0) {
			if (l1 != null) {
				tempSum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				tempSum += l2.val;
				l2 = l2.next;
			}

			p.next = new ListNode(tempSum % 10);
			p = p.next;
			tempSum = tempSum / 10;
		}
		return head.next;
	}

	/**
	 * SWAP in PAIRS Given a linked list, swap every two adjacent nodes and
	 * return its head. For example, Given 1->2->3->4, you should return the
	 * list as 2->1->4->3.
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// a fake head
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = dummy;
		ListNode curr = head;
		ListNode nextNode = curr.next;

		while (curr != null && nextNode != null) {

			ListNode tempNode = nextNode.next;
			prev.next = nextNode;
			nextNode.next = curr;
			prev = curr;
			curr.next = tempNode;

			curr = curr.next;

			if (tempNode != null)
				nextNode = tempNode.next;
		}

		return dummy.next;
	}

	// find max in list
	public int findMax() {
		return maxValue(head);
	}

	public int maxValue(ListNode head) {

		if (head == null)
			throw new IllegalArgumentException();
		if (head.next == null)
			return head.val;

		ListNode curr = head;
		int max = curr.val;
		while (curr != null) {
			max = Math.max(max, curr.val);
			curr = curr.next;
		}

		return max;
	}

	// Print reverse linkedlist RECCURSIVELY
	public void printInRev() {
		printRev(head);
	}

	public void printRev(ListNode head) {
		ListNode curr = head;
		if (curr == null)
			return;
		printRev(curr.next);
		System.out.print(curr.val + " ");
	}

	// reverse nodes in a group of k
	/**
	 * Given a linked list, reverse the nodes of a linked list k at a time and
	 * return its modified list.
	 * 
	 * k is a positive integer and is less than or equal to the length of the
	 * linked list. If the number of nodes is not a multiple of k then left-out
	 * nodes in the end should remain as it is.
	 * 
	 * You may not alter the values in the nodes, only nodes itself may be
	 * changed.
	 * 
	 * Only constant memory is allowed.
	 * 
	 * For example, Given this linked list: 1->2->3->4->5
	 * 
	 * For k = 2, you should return: 2->1->4->3->5
	 * 
	 * For k = 3, you should return: 3->2->1->4->5
	 * 
	 */
	//HARD Leetcode - 25
	public ListNode reverseKGroup(ListNode head, int k) {
        return null;
    }

}
