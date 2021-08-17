class Solution {
    
    static TreeNode a, b,prev;
    
    public void recoverTree(TreeNode root) {
        a = null;
        b = null;
        prev = null;
        recoverTreeUtil(root);
        
        if(a != null) {
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
    }
    
    public void recoverTreeUtil(TreeNode root) {
        if(root == null) return;
        
        recoverTreeUtil(root.left);
        
        if(prev != null && root.val < prev.val) {
            b = root;
            if(a == null) {
                a = prev;
            } else {
                return;
            }
        }
        prev = root;
        
        recoverTreeUtil(root.right);
    }
}
