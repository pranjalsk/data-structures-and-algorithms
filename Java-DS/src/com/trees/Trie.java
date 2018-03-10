package com.trees;

import java.util.Arrays;

class TrieNode {

	TrieNode[] children = new TrieNode[26];

	boolean isLeaf;

	public TrieNode() {
		isLeaf = false;
		Arrays.fill(children, null);
	}
}

// ------------------------------------
class Trie {

	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String key) {

		TrieNode curr = root;

		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';

			if (curr.children[index] == null) {
				curr.children[index] = new TrieNode();
			}

			curr = curr.children[index];
		}
		curr.isLeaf = true;
	}

	public boolean search(String key) {
		TrieNode curr = root;

		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';

			if (curr.children[index] == null) {
				return false;
			}
			curr = curr.children[index];
		}
		if (curr != null && curr.isLeaf)
			return true;

		return false;
	}

	public boolean startsWith(String key) {
		TrieNode curr = root;

		for (int i = 0; i < key.length(); i++) {

			int index = key.charAt(i) - 'a';
			if (curr.children[index] == null) {
				return false;
			}
			curr = curr.children[index];
		}
		if (curr != null)
			return true;

		return false;
	}

}

class TrieDriver {
	// reference geeksforgeeks
	public static void main(String[] args) {

		Trie t = new Trie();

		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };

		String output[] = { "Not present in trie", "Present in trie" };

		for (int i = 0; i < keys.length; i++)
			t.insert(keys[i]);

		// Search for different keys
		if (t.search("the") == true)
			System.out.println("the --- " + output[1]);
		else
			System.out.println("the --- " + output[0]);

		if (t.search("these") == true)
			System.out.println("these --- " + output[1]);
		else
			System.out.println("these --- " + output[0]);

		if (t.search("their") == true)
			System.out.println("their --- " + output[1]);
		else
			System.out.println("their --- " + output[0]);

		if (t.search("thaw") == true)
			System.out.println("thaw --- " + output[1]);
		else
			System.out.println("thaw --- " + output[0]);

	}
}
