class Solution
{
    //Function to return the lowest common ancestor in a Binary Tree.
	Node lca(Node root, int n1,int n2) {
		Node lnode, rnode;
		
		if(root == null) return null;
		
		if(root.data == n1 || root.data == n2) return root;
		
		lnode = lca(root.left, n1, n2);
		rnode = lca(root.right, n1, n2);
		
		if(lnode != null && rnode != null) return root;
		
		return lnode != null ? lnode : rnode;
	}
}
