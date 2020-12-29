package tree;

import java.util.Scanner;

public class Trees {
	
	static Scanner sc = null ;
	
	public static void main(String[] args) {
		
		sc = new Scanner (System.in);
		System.out.println("Enter root : ");
		
		Node root = createTree() ;
//		inOrder(root);
//		System.out.println();
//		preOrder(root);
//		System.out.println();
//		postOrder(root);
		
//		getsize(root);
	}
	
	static Node createTree() {
		
		Node root = null ;
		int data = sc.nextInt();
		if(data == -1) return null;
		
		root = new Node (data);
		
		System.out.println("Enter left for " + data);
		root.left = createTree();
		
		System.out.println("Enter right for " + data);
		root.right = createTree();
		
		return root ;
	}
	
	static void inOrder(Node root) {
		if(root == null) return ;
		
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	static void preOrder(Node root ) {
		if(root == null) return;
		
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	static void postOrder(Node root) {
		if(root == null) return ;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	static int getSize(Node root) {
		if(root == null) return 0 ;
        return 1 + getSize(root.left) + getSize(root.right) ;
	}
	
	static void display(Node node) {
        if(node == null) return;
        String str ="";

        if(node.left == null) str += ".";
        else str += node.left.data;

        str += " => " + node.data + " <= ";

        if(node.right == null) str+= ".";
        else str += node.right.data;

        System.out.println(str);
        display(node.left);
        display(node.right);
    }
	
}

class Node {
	Node left , right ;
	int data ;
	
	public Node(int data) {
		this.data = data ;
	}
}
