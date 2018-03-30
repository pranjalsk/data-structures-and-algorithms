package com.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BTViews {

	// Rightside view of BT
	
	//Reverse BFS level order traversal
	
	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> list = new ArrayList<>();
		
        if(root == null) return list;
		
		ArrayDeque<TreeNode> q = new ArrayDeque<>();
		
		q.offer(root);
		
		while(!q.isEmpty()){
			
			int size = q.size();
			for(int i = 0;i<size;i++){
				
				TreeNode curr = q.poll();
				
				if(i == 0) 
					list.add(curr.val);
				
				if(curr.right != null) q.offer(curr.right);
				if(curr.left != null) q.offer(curr.left);	
			}
		}
		
		return list;
		
	}
}
