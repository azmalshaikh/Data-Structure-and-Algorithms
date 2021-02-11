package trie;

import java.util.Scanner;

class Node {
	Node child[] = new Node [26];
	boolean isEnd;
}

public class Trie {
	
	Node root;
	
	void insert(String s) {
		Node temp = root;
		for(int i=0; i<s.length(); i++) {
			int a = s.charAt(i) - 'a';
			
			if(temp.child[a] == null) {
				Node toAdd = new Node();
				temp.child[a] = toAdd;
			}
			temp = temp.child[a];			
		}
		temp.isEnd = true;
	}
	
	boolean search(String s) {
		Node temp = root;
		for(int i=0; i<s.length(); i++) {
			int a = s.charAt(i) - 'a';
			
			if(temp.child[a] == null) return false;
			
			temp = temp.child[a];
		}
		
		return temp.isEnd;
	}
	
	Node delete(Node root, String s, int i) {
		if(root == null) return null;
		
		if(i == s.length()) {
			root.isEnd = false;
			if(isEmpty(root)) {
				root = null;
			}
			return root;
		}
		
		int index = s.charAt(i) - 'a';
		root.child[index] = delete(root.child[index], s, i+1);
		
		if(isEmpty(root) && root.isEnd == false) {
			root = null;
		}
		
		return root;
	}
	
	boolean isEmpty(Node root) {
		for(int i=0; i<26; i++) {
			if(root.child[i] != null) return false;
		}
		
		return true;
	}

	public static void main(String[] args) {	
		
		Trie trie = new Trie();
		trie.root = new Node();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of elements");
		int n = sc.nextInt();
		System.out.println("Enter elements");
		for(int i=0; i<n; i++) {
			String a = sc.next();
			trie.insert(a);
		}
		
		trie.delete(trie.root, "zoo", 0);
		System.out.println(trie.search("zoo"));
		trie.delete(trie.root, "geek", 0);
		System.out.println(trie.search("geek"));
		trie.delete(trie.root, "bad", 0);
		System.out.println(trie.search("bad"));
	}

}
