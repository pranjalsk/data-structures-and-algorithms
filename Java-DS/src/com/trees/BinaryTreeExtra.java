package com.trees;

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
		// traverse tree from room and compare values
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
}
