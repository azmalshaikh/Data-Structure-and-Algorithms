class Solution {
    
    static int maxTime;
    
    public static void burnTreeUtil(Node root, int time, Node blocker) {
        if(root == null || root == blocker) return;
        
        maxTime = Math.max(maxTime, time);
        
        burnTreeUtil(root.left, time+1, blocker);
        burnTreeUtil(root.right, time+1, blocker);
    }
    
    public static int burnTree(Node root, int target) {
        
        if(root == null) return -1;
        
        if(root.data == target) {
            burnTreeUtil(root, 0, null);
            return 1;
        }
        
        int leftTime = burnTree(root.left, target);
        if(leftTime != -1) {
            burnTreeUtil(root, leftTime, root.left);
            return leftTime + 1;
        }
        
        int rightTime = burnTree(root.right, target);
        if(rightTime != -1) {
            burnTreeUtil(root, rightTime, root.right);
            return rightTime + 1;
        }
        
        return -1;
    }
    
    public static int minTime(Node root, int target) {
        maxTime = 0;
        burnTree(root, target);
        
        return maxTime;
    }
}
