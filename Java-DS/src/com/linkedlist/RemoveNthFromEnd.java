package com.linkedlist;

public class RemoveNthFromEnd {

public ListNode removeNthFromEnd(ListNode head, int n) {
        
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow =dummy;
        
        if(n==0) return head;
        
        
        //if(head.next == null ) return head;
        
        for(int i=0;i<=n;i++){
            if(fast == null){
                return head;
            }
            fast = fast.next;
        }
        
        while(fast != null){
            slow = slow.next;
            fast =fast.next;
        }
        
        //slow pointing to Nthnode from last
        /*if(slow.next == null){
            slow = null;
        }
        else{
            slow.val = slow.next.val;
            slow.next = slow.next.next;
        }*/
        
        slow.next = slow.next.next;
        
        return dummy.next;
        
        
    }
	
}
