package com.trees;

public class TreeTrivialOps {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null && q != null || p != null && q == null)
			return false;

		if (p.val != q.val)
			return false;
		boolean left = isSameTree(p.left, q.left);
		boolean right = isSameTree(p.right, q.right);

		if (left && right)
			return true;
		return false;
	}

	public boolean isSubtree(TreeNode main, TreeNode sub) {
		if (sub == null)
			return true;
		if (main == null)
			return false;

		if (isSameTree(main, sub))
			return true;

		boolean left = isSubtree(main.left, sub);
		boolean right = isSubtree(main.right, sub);

		if (left || right)
			return true;
		
		return false;
	}

	public boolean isSymmetric(TreeNode root){
		return isMirror(root,root);
	}

	private boolean isMirror(TreeNode r1, TreeNode r2) {

		if(r1 == null && r2==null) return true;
		if(r1 == null || r2==null) return false;
		
		if(r1.val != r2.val) return false;
		
		boolean left = isMirror(r1.left, r2.right);
		boolean right = isMirror(r1.right, r2.left);
		
		if(left && right) return true;
		
		return false;
		
	}
	
	
	
	
	
}
