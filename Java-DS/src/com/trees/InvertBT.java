package com.trees;

import java.util.ArrayDeque;

public class InvertBT {

	//BFS approach
	public TreeNode invertTree(TreeNode root) {
    
		if(root == null) return root;
		ArrayDeque<TreeNode> q = new ArrayDeque<>();
		
		q.offer(root);
		
		while(!q.isEmpty()){
			
			TreeNode curr = q.poll();
			
			//swap nodes
			TreeNode temp = curr.left;
			curr.left = curr.right;
			curr.right = temp;
			
			if(curr.left!=null) q.offer(curr.left);
			if(curr.right!=null) q.offer(curr.right);
		}
		return root;
    }
	
	
	//recursive
	public TreeNode invertTreeRecur(TreeNode root) {
		
		if(root == null) return null;
		
		TreeNode left = invertTreeRecur(root.left);
		TreeNode right = invertTreeRecur(root.right);
		
		root.left = right;
		root.right = left;
		
		return root;
	
	}
	
	
}
