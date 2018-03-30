package com.trees;


/**
 *  Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node. 
If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL
 */

class TreeLinkNode{
	
	int val;
	TreeLinkNode left;
	TreeLinkNode right;
	TreeLinkNode next;
	
}

public class NextPointerBT {

	public void connect(TreeLinkNode root){
		
		if(root == null) return;
		
		TreeLinkNode pre = root;
		TreeLinkNode curr = root;
		while(pre.left != null){
			
			curr = pre;
			while(curr != null){
				curr.left.next = curr.right;
				
				if(curr.next != null)
					curr.right.next = curr.next.left;
				
				curr = curr.next;
				
			}
			pre = pre.left;
		}
		
		
	}
	
}
