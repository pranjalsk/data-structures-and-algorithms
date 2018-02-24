package com.linkedlist;

public class Driver {

	public static void main(String[] args) {
		
		ListOperations ops = new ListOperations();
		
		ops.add(new ListNode(12));
		ops.add(new ListNode(1));
		ops.add(new ListNode(6));
		ops.add(new ListNode(15));
		ops.add(new ListNode(78));
		ops.add(new ListNode(14));
		ops.add(new ListNode(112));
		
/*		//palimdrome
		ops.add(new ListNode(12));
		ops.add(new ListNode(11));
		ops.add(new ListNode(6));
		ops.add(new ListNode(15));
		ops.add(new ListNode(6));
		ops.add(new ListNode(11));
		ops.add(new ListNode(12));
		System.out.println(ops.ispalim());*/
		
		ops.display();
		System.out.print("\nSize: "+ops.getSize());
		System.out.println();
			
		System.out.println("Max elem: "+ ops.findMax());
		
		ops.printInRev();
		
		//ops.sortedList();
		
		//ops.delNode(1);
	
	}
}
