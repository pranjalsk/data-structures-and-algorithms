package com.trees;

import java.util.*;
import java.util.logging.Level;

//BT node data structure
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;

	public TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	public TreeNode(int val) {
		super();
		this.val = val;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

}

class BinaryTree {

	TreeNode root;

	public BinaryTree() {
		super();
		this.root = null;
	}

	public BinaryTree(TreeNode root) {
		super();
		this.root = root;
	}

	// ------------------INSERT----------------------
	public void insertNode(int val) {
		root = addNode(root, val, null);
	}

	public TreeNode addNode(TreeNode node, int val, TreeNode parent) {

		TreeNode newNode = new TreeNode(val, null, null, parent);
		if (node == null) {
			return newNode;
		} else {
			if (val < node.val) {
				node.left = addNode(node.left, val, node);
			} else {
				node.right = addNode(node.right, val, node);
			}
			return node;
		}
	}

	// ---------------------RECURSIVE--------------------

	// Inorder---------------------------------------------------------
	public ArrayList<Integer> recursiveInorder() {
		ArrayList<Integer> result = new ArrayList<>();
		inorder(root, result);
		return result;
	}

	public void inorder(TreeNode node, ArrayList<Integer> result) {

		if (node == null) {
			return;
		}
		inorder(node.left, result);
		// printTree(node);
		result.add(node.val);
		inorder(node.right, result);
	}

	// preorder-----------------------------------------------------
	public ArrayList<Integer> recursivePreorder() {
		ArrayList<Integer> result = new ArrayList<>();
		preorder(root, result);
		return result;
	}

	public void preorder(TreeNode node, ArrayList<Integer> result) {

		if (node == null) {
			return;
		}
		// printTree(node);
		result.add(node.val);
		preorder(node.left, result);
		preorder(node.right, result);
	}

	// postorder---------------------------------------------------------
	public ArrayList<Integer> recursivePostorder() {
		ArrayList<Integer> result = new ArrayList<>();
		postorder(root, result);
		return result;
	}

	public void postorder(TreeNode node, ArrayList<Integer> result) {

		if (node == null) {
			return;
		}
		postorder(node.left, result);
		postorder(node.right, result);
		// printTree(node);
		result.add(node.val);
	}

	// ---------------------------ITERATIVE-------------------------------------------
	public ArrayList<Integer> inorderIterative() {

		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		ArrayList<Integer> result = new ArrayList<>();
		TreeNode curr = root;

		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			result.add(curr.val); // IMP line
			curr = curr.right;
		}
		return result;
	}

	// ----------------PRE ORDER--------------
	public ArrayList<Integer> preorderIterative() {
		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		ArrayList<Integer> result = new ArrayList<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				result.add(curr.val); // IMP Line
				curr = curr.left;
			}
			curr = stack.pop();
			curr = curr.right;
		}
		return result;
	}

	// --------------POST ORDER---------------- //Tip: reverse process of
	// preorder and reverse answer
	public ArrayList<Integer> postorderIterative() {

		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		ArrayList<Integer> result = new ArrayList<>();
		TreeNode curr = root;

		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				result.add(curr.val); // IMP Line
				curr = curr.right; // note the difference
			}
			curr = stack.pop();
			curr = curr.left; // note difference
		}
		Collections.reverse(result); // reverse list
		return result;
	}

	public int height() {
		return heightTree(root);
	}

	// Height of a tree
	public int heightTree(TreeNode node) {
		if (node == null)
			return -1; // Note here
		int leftheight = heightTree(node.left);
		int rightheight = heightTree(node.right);
		int ht = 1 + Math.max(leftheight, rightheight);
		return ht;
	}

	// BFS-Level traversal
	// -----------------------------
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			ArrayList<Integer> subList = new ArrayList<Integer>();
			int count = q.size();
			for (int i = 0; i < count; i++) {
				TreeNode node = q.poll();
				subList.add(node.val);
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
			result.add(subList);
		}
		return result;
	}

	// --------------------LEVEL TRAVERSAL-----------------------------
	public void levelOrder() {
		/*int ht = heightTree(root);
		for (int i = 0; i < ht + 1; i++) {
			breadthWiseTraversal(root, i);
		}*/
		System.out.println(levelOrder(root));
	}

	public void breadthWiseTraversal(TreeNode node, int level) {
		if (level == 0) {
			System.out.print(node.val + " ");
		} else {
			if (node.left != null) {
				breadthWiseTraversal(node.left, level - 1);
			}
			if (node.right != null) {
				breadthWiseTraversal(node.right, level - 1);
			}
		}
	}

	// Find Kth smallest element -- inorder gives us sorted order
	public int kthSmallest(TreeNode node, int k) {
		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		if (node == null)
			return 0;
		int count = 0;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			count++;
			if (count == k) {
				break;
			}
			node = node.right;
		}
		return node.val;
	}

	public int kthSmallestCaller(int k) {
		return kthSmallest(root, k);
	}

	// --Validate BST----------------------------------------//Tip: Use inorder
	public boolean isValidBST(TreeNode node) {
		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		if (node == null)
			return true;
		// maintain prev pointer
		TreeNode prev = null;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			if (prev != null && node.val <= prev.val) { // breaking condition
				return false;
			}
			// increment pointers
			prev = node;
			node = node.right;
		}
		return true;
	}

	public boolean isValidBSTCaller() {
		return isValidBST(root);
	}

	// Path sum : In a BT, check whether there is a a "root-to-leaf path" with
	// sum = target
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;

		// check if its a leaf node
		if (root.left == null && root.right == null && sum - root.val == 0)
			return true;

		boolean lefthas = false, righthas = false;
		if (root.left != null) {
			lefthas = hasPathSum(root.left, sum - root.val);
		}
		if (root.right != null) {
			righthas = hasPathSum(root.right, sum - root.val);
		}

		if (lefthas || righthas)
			return true;
		else
			return false;
	}

	// **IMP*****Path sum 2: Display all path equal to sum =target
	public void printPathSum(TreeNode root, int sum, Stack<Integer> stack) {
		if (root == null)
			return;

		stack.push(root.val);
		// check if its a leaf node
		if (root.left == null && root.right == null && sum - root.val == 0) {
			System.out.println(stack);
		}

		// Question Print all paths to leaf: just remove sum-root.val condition
		// from above line
		// Question : print path to given leaf node: change condition in above
		// line to :(root.left==null && root.right==null && root.val ==
		// givenNum)
		// Question: print path to given any node from root:change condition in
		// above line to just: (root.val == givenNum)

		if (root.left != null) {
			printPathSum(root.left, sum - root.val, stack);
		}
		if (root.right != null) {
			printPathSum(root.right, sum - root.val, stack);
		}
		stack.pop();
	}

	public void pathSumCaller(int sum, Stack<Integer> stack) {
		System.out.println("Has path sum?: " + hasPathSum(root, sum));
		printPathSum(root, sum, stack);
	}

	// ************** LCA in BT----------------------------------------------

	public TreeNode LCABT(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null) {
			return null;
		}

		if (root == p || root == q) {
			return root;
		}

		TreeNode left = LCABT(root.left, p, q);
		TreeNode right = LCABT(root.right, p, q);

		if (left != null && right != null) {
			return root;
		} else {
			if (left != null)
				return left;
			else
				return right;
		}

	}

	// ************** LCA in BST----------------------------------------------
	public TreeNode LCABST(TreeNode root, TreeNode p, TreeNode q) {

		if (root.val > p.val && root.val > q.val) {
			return LCABST(root.left, p, q);
		} else if (root.val < p.val && root.val < q.val) {
			return LCABST(root.right, p, q);
		} else {
			return root;
		}

	}

	// BFS on tree------------------------------------------------
	public void BFS(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();

		q.add(root);

		while (!q.isEmpty()) {
			TreeNode temp = q.poll();

			System.out.print(temp.val + " ");

			if (temp.left != null)
				q.add(temp.left);

			if (temp.right != null)
				q.add(temp.right);
		}

	}

	public void BFScaller() {
		BFS(root);
	}

	// DFS -- op: (Right DFS first)DFS: 15 28 32 20 23 22 21 16 7 9 4
	public static void DFS(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();

		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			System.out.print(curr.val + " ");
			;
			if (curr.left != null) {
				stack.push(curr.left);
			}
			if (curr.right != null) {
				stack.push(curr.right);
			}
		}
	}

	public void DFScaller() {
		DFS(root);
	}

	// --------Min depth of BT
	// Recursive
	public int minDepth(TreeNode root) {

		if (root == null)
			return 0;

		int depth = 0;
		if (root.left != null && root.right != null) {
			int lh = minDepth(root.left);
			int rh = minDepth(root.right);
			depth = Math.min(lh, rh);
		} else if (root.left != null && root.right == null) {
			depth = minDepth(root.left);
		} else if (root.right != null && root.left == null) {
			depth = minDepth(root.right);
		}

		return depth + 1;
	}

	// Min depth using BFS-----------------------------------

	// COUNTING--------------------------------------------
	// Count all nodes
	public void countNodes() {
		int count = countAllNodes(root);
		System.out.print(" " + count);

	}

	private int countAllNodes(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + countAllNodes(node.left) + countAllNodes(node.right);
	}

	// Count all leaf nodes
	public void countLeaves() {
		int count = countLeafNodes(root);
		System.out.print(" " + count);
	}

	private int countLeafNodes(TreeNode node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		return countLeafNodes(node.left) + countLeafNodes(node.right);
	}

	public void printTree(TreeNode node) {
		if (node.left != null && node.right != null)
			System.out.println("node:" + node.val + "--Left:" + node.left.val + "--right:" + node.right.val);
		else if (node.left != null && node.right == null)
			System.out.println("node:" + node.val + "--Left:" + node.left.val + "--right:" + node.right);
		else if (node.left == null && node.right != null)
			System.out.println("node:" + node.val + "--Left:" + node.left + "--right:" + node.right.val);
		else
			System.out.println("node:" + node.val + "--Left:" + node.left + "--right:" + node.right);
	}

	// --------------------------------------------
	// Boundary traversal or anticlockwise traversal
	// Explanation-
	// https://javabypatel.blogspot.com/2015/09/boundary-traversal-of-binary-tree.html
	public void boundaryAnticlockCaller() {
		boundaryTraversal(root);
	}

	public void boundaryTraversal(TreeNode root) {
		System.out.print(root.val + " ");
		printLeftEdge(root.left);
		printLeaf(root);
		printRightEdge(root.right);
	}

	// top down
	private void printLeftEdge(TreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			return;

		System.out.print(root.val + " ");
		if (root.left == null) {
			printLeftEdge(root.right);
		} else {
			printLeftEdge(root.left);
		}
	}

	// bottom up print
	private void printRightEdge(TreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			return;

		if (root.right == null) {
			printLeftEdge(root.left);
		} else {
			printLeftEdge(root.right);
		}
		System.out.print(root.val + " ");
	}

	private void printLeaf(TreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			System.out.print(root.val + " ");
			return;
		}
		printLeaf(root.left);
		printLeaf(root.right);
	}

	// Vertical Order traversal--using
	// BFS+MAP---------------------------------------------
	public List<List<Integer>> verticalOrderCaller() {
		return verticalOrder(root);
	}

	public List<List<Integer>> verticalOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();
		int min = 0;
		int max = 0;

		Queue<TreeNode> q = new LinkedList<>();
		Queue<Integer> hdq = new LinkedList<>();
		HashMap<Integer, List<Integer>> map = new HashMap<>();

		// BFS
		if (root == null)
			return res;

		q.add(root);
		hdq.add(0);

		while (!q.isEmpty()) {
			// poll the root
			TreeNode curNode = q.poll();
			Integer hd = hdq.poll();

			// fill the map
			/*
			 * put method inserts the element ( key value pair ) into the Map.
			 * If the Map already contains an element with the same Key, the
			 * value is overwritten with the new element value.
			 * 
			 * putIfAbsent performs the check to see if the same Key already
			 * existed in the Map and will only all a new element if it's not
			 * already there ( Match by the Key )
			 * 
			 */
			map.putIfAbsent(hd, new ArrayList<Integer>());
			map.get(hd).add(curNode.val);
			if (curNode.left != null) {

				// enqueue left
				q.add(curNode.left);
				hdq.add(hd - 1);

				min = Math.min(min, hd - 1); // contains min hd/order in the
												// tree
			}

			if (curNode.right != null) {

				// enqueue right
				q.add(curNode.right);
				hdq.add(hd + 1);

				max = Math.max(max, hd + 1); // contains max hd/order in the
												// tree
			}
		}

		// -----------
		// adding result
		for (int i = min; i <= max; i++) {
			res.add(map.get(i));
		}
		return res;
	}

	// ------------------Delete node from BST-----------------
	public TreeNode getMinimumNode(TreeNode root) {
		if (root == null)
			return null;
		if (root.left == null)
			return root;
		else
			return getMinimumNode(root.left);
	}

	public TreeNode deleteNode(TreeNode root, int val) {
		if (root == null)
			return null;

		// traverse until you find node
		if (val < root.val) {
			root.left = deleteNode(root.left, val);
		} else if (val > root.val) {
			root.right = deleteNode(root.right, val);
		} else {
			// if nodeToBeDeleted have both children
			if (root.left != null && root.right != null) {
				TreeNode temp = root;
				// Finding minimum element from right
				TreeNode minNodeForRight = getMinimumNode(temp.right);
				// Replacing current node with minimum node from right subtree
				root.val = minNodeForRight.val;
				// Deleting minimum node from right now
				deleteNode(root.right, minNodeForRight.val);

			}
			// if nodeToBeDeleted has only left child
			else if (root.left != null) {
				root = root.left;
			}
			// if nodeToBeDeleted has only right child
			else if (root.right != null) {
				root = root.right;
			}
			// if nodeToBeDeleted do not have child (Leaf node)
			else
				root = null;
		}
		return root;
	}

	public void deleteCaller(int val) {
		deleteNode(root, val);
	}

	// ---------------------
	/**
	 * Given an array where elements are sorted in ascending order, convert it
	 * to a height balanced BST
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSThelper(nums,0, nums.length-1);
    }
    
    public TreeNode sortedArrayToBSThelper(int [] nums, int low, int high){
        
        if(low > high) return null;
        
        if(low == high) return new TreeNode(nums[low]);
        
        int mid = low + (high-low)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = sortedArrayToBSThelper(nums,low,mid-1);
        root.right = sortedArrayToBSThelper(nums, mid+1, high);
        
        return root;
    }

}

public class BinaryTreeOps {
	public static void main(String[] args) {

		BinaryTree obj = new BinaryTree();

		obj.insertNode(15);
		obj.insertNode(7);
		obj.insertNode(28);
		obj.insertNode(4);
		obj.insertNode(9);
		obj.insertNode(20);
		obj.insertNode(32);
		obj.insertNode(16);
		obj.insertNode(23);
		obj.insertNode(22);
		obj.insertNode(21);

		System.out.println("------------RECURSIVE---------------");
		System.out.println("Inorder:" + obj.recursiveInorder());
		System.out.println("preorder:" + obj.recursivePreorder());
		System.out.println("postorder:" + obj.recursivePostorder());

		System.out.println("-------------ITERATIVE---------------");
		System.out.println("inorder:" + obj.inorderIterative());
		System.out.println("preorder:" + obj.preorderIterative());
		System.out.println("postorder:" + obj.postorderIterative());

		System.out.println("Tree Hight:" + obj.height());

		System.out.print("Level order:*** ");
		obj.levelOrder();


		
		System.out.println("\nKth(3) Smallest is:" + obj.kthSmallestCaller(3));

		System.out.println("Is valid BST: " + obj.isValidBSTCaller());

		System.out.println("Path Sum");
		Stack<Integer> stackPathSum = new Stack<>();
		obj.pathSumCaller(31, stackPathSum);
		// obj.pathSumCaller(129,stackPathSum);
		// obj.pathSumCaller(45,stackPathSum);

		System.out.print("\nBFS: ");
		obj.BFScaller();

		System.out.print("\nDFS: ");
		obj.DFScaller();

		System.out.print("\nBoundary Traversal anticlockwise: ");
		obj.boundaryAnticlockCaller();

		System.out.print("\nVertical order: ");
		System.out.println(obj.verticalOrderCaller());

		System.out.println("\nDelete node 20: ");
		obj.deleteCaller(20);

		System.out.println("Inorder:" + obj.recursiveInorder());
	}
}
