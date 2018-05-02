package com.trees;

import java.util.*;

public class BinaryTreeExtra {

	// Given a binary tree, find the maximum path sum.
	/**
	 * For this problem, a path is defined as any sequence of nodes from some
	 * starting node to any node in the tree along the parent-child connections.
	 * The path must contain at least one node and does not need to go through
	 * the root.
	 * 
	 * @param root
	 * @return
	 */
	public int maxPathSum(TreeNode root) {
		return 0;
	}

	// Construct Binary Tree from Preorder and Inorder Traversal - 105
	
	

	// Inorder Successor in BST
	public TreeNode inOrderSuccessor(TreeNode root, TreeNode node) {
		// we want to find succ of node
		if (node.right != null) {
			return leftMostChild(node.right);
		}

		TreeNode succ = null;
		// traverse tree from root and compare values
		while (root != null) {
			if (node.val > root.val)  // succ will definately be in right tree
				root = root.right;
			
			else if (node.val < root.val) { // succ can be in left subtree or root itself
				succ = root;
				root = root.left;
			}
			else
				break;
		}

		return succ;
	}

	private TreeNode leftMostChild(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	
	//create a BST with minimal depth from a given sorted array of unique integers
	public TreeNode createMinimalSubtree(int [] arr, int L, int H){
		
		if(L > H){
			return null;
		}
		int M = L + (H-L)/2;
		
		TreeNode root = new TreeNode(arr[M]);
		root.left = createMinimalSubtree(arr, L, M-1);
		root.right = createMinimalSubtree(arr, M+1, H);
		return root;
	}
	
	
	public List<LinkedList<Integer>> listOfDepths(TreeNode root){
		
		List<LinkedList<Integer>> result = new ArrayList<>();
		
		ArrayDeque<TreeNode> q = new ArrayDeque<>();
		
		q.offer(root);
		
		while(!q.isEmpty()){
			LinkedList<Integer> temp = new LinkedList<>();
			int size = q.size();
			for(int i=0;i<size;i++){
				TreeNode curr = q.poll(); 
				temp.add(curr.val);
				if(curr.left != null)
					q.offer(curr.left);
				if(curr.right != null)
					q.offer(curr.right);
			}
			result.add(temp);		
		}
		return result;
	}
	
	
	/**
	 * Given a binary tree, determine if it is height-balanced.

	For this problem, a height-balanced binary tree is defined as:

    a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
	 */
	public boolean isBalanced(TreeNode root) {
        
        if(root == null) return true;
        
        int leftMax = calcMaxHt(root.left);
        int rightMax = calcMaxHt(root.right);
        
        if(Math.abs(rightMax-leftMax)>1)return false;
        
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        
        return (left&&right);        
        
    }

    
    private int calcMaxHt(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(calcMaxHt(root.left),calcMaxHt(root.right));
    }
}
