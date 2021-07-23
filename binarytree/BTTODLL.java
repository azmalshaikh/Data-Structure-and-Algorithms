class Solution
{
    
    static Node prev = null;
    
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root) {
	    Node dummy = new Node(-1);
	    prev = dummy;
	    
	    bToDll1(root);
	    
	    Node head = dummy.right;
	    prev.right = head.left = null;
	    
	    return head;
    }
    
    void bToDll1(Node root) {
        if(root == null) return;
        
        bToDll1(root.left);
        
        prev.right = root;
        root.left = prev;
        
        prev = root;
        
        bToDll1(root.right);
    }
}
