package com.trees;

import java.util.Stack;

/**
 * Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 */

//DFS approach
public class SumOfLeftLeaves {
	
	public int sumOfLeftLeaves(TreeNode root) {
		if(root == null) return 0 ;
	    int sum = 0;
	    Stack<TreeNode> stack = new Stack<>();
	    
	    stack.push(root);
	    
	    while(!stack.isEmpty()){
	        
	        TreeNode curr = stack.pop();
	        if(curr.left!=null){
	            
	        	//Note this extra condition...else is just DFS
	            if(curr.left.left==null && curr.left.right == null)
	                sum += curr.left.val;
	            else
	                stack.push(curr.left);
	        }
	        if(curr.right !=null){
	            stack.push(curr.right);
	        }
	    }
	    return sum;
	}
}
