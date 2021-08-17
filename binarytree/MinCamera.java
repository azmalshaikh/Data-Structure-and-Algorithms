class Solution {
    
    static int camera;
    
    public int mincamera(TreeNode root) {
        if(root == null) return 1;
        
        int left = mincamera(root.left);
        int right = mincamera(root.right);
        
        if(left == -1 || right == -1) {
            camera++;
            return 0;
        }
        
        if(left == 0 || right == 0) {
            return 1;
        }
        
        return -1; // Need a camera;
    }
    
    public int minCameraCover(TreeNode root) {
        camera = 0;
        if(mincamera(root) == -1) camera++;
        return camera;
    }
}
