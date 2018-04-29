package com.trees;

import java.util.ArrayDeque;

public class PathSumInTree {

	public int pathSum(TreeNode root, int sum) {
        
	      int count = 0;
	      
	      if(root == null) return count;
	      
	      ArrayDeque<TreeNode> q = new ArrayDeque<>();
	      
	      q.offer(root);
	      
	      while(!q.isEmpty()){
	        
	        TreeNode curr = q.poll();
	        
	        int pathCounts = DFS(curr,sum);
	        count+=pathCounts;
	        
	        if(curr.left!=null) q.offer(curr.left);
	        if(curr.right!=null) q.offer(curr.right);
	      }
	      
	      return count;
	    }
	  
	    public int DFS(TreeNode root, int target){
	      
	      int cnt = 0;
	      if(root == null) return cnt;
	      
	      if(target-root.val == 0)cnt++;
	      
	      int leftSide = DFS(root.left, target-root.val);
	      int rightSide = DFS(root.right, target-root.val);
	      
	      return (cnt + leftSide + rightSide);
	    }

	
	
}
