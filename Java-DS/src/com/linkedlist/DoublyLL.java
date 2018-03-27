package com.linkedlist;

class ListNodeD {

	int val;
	ListNodeD next;
	ListNodeD prev;

	public ListNodeD(int val) {
		super();
		this.val = val;
		this.next = null;
		this.prev = null;
	}

	public ListNodeD(int val, ListNodeD next, ListNodeD prev) {
		super();
		this.val = val;
		this.next = next;
		this.prev = prev;
	}

}

public class DoublyLL {

	ListNodeD head;
	public DoublyLL(ListNodeD head) {
		this.head = head;
	}

	public void addFront(int val) {

		ListNodeD newNode = new ListNodeD(val);

		newNode.next = head;
		newNode.prev = null;

		if (head != null)
			head.prev = newNode;

		head = newNode;
	}

	public void addBack(int val) {

		ListNodeD newNode = new ListNodeD(val);

		ListNodeD curr = head;

		if (head == null) {
			newNode.prev = null;
			head = newNode;
			return;
		}

		while (curr.next != null) {
			curr = curr.next;
		}

		curr.next = newNode;
		newNode.prev = curr;
		newNode.next = null;
	}

	public void insertAfter(ListNodeD prev, int val) {

		ListNodeD newNode = new ListNodeD(val);

		if (prev == null) {
			throw new IllegalArgumentException();
		}

		newNode.next = prev.next;
		prev.next = newNode;
		newNode.prev = prev;

		if (newNode.next != null) {
			newNode.next.prev = newNode;
		}
	}
	
	
	public void deleteNode(ListNodeD del){
		
		if(head == null || del ==null) return;
		
		if(head == del){
			head = head.next;
		}
		
		if(del.next != null){
			del.next.prev = del.prev;
		}
		if(del.prev != null){
			del.prev.next = del.next;
		}
		return;
	}

	public void printList(){
		
		ListNodeD curr = head;
		while(curr != null){
			System.out.print(curr.val + "-->");
			curr = curr.next;
		}
	}
	
	
	public static void main(String[] args) {
		ListNodeD head = null;
		DoublyLL dll = new DoublyLL(head);
		dll.addBack(12);
		dll.addBack(13);
		dll.addBack(14);
		dll.printList();
		
	}
}
