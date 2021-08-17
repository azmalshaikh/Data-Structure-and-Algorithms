class Solution {
    public int longestZigZag(TreeNode root) {
        ans = 0;
        zigzag(root);
        return ans;
    }
    
    static int ans;
    
    public int[] zigzag(TreeNode root) {
        
        if(root == null) return new int[] {-1, -1};
        
        int left[] = zigzag(root.left);
        int right[] = zigzag(root.right);
        
        ans = Math.max(ans, 1 + Math.max(left[1], right[0]));
        
        return new int[] {left[1]+1, right[0]+1};
    }
}
