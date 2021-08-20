class Solution {
    
    static List<List<Integer>> ans;
    
    public void pathSum(TreeNode root, int targetSum, ArrayList<Integer> temp) {
        
        if(root == null) return;
        
        if(root.left == null && root.right == null && targetSum == root.val) {
            temp.add(root.val);
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        
        temp.add(root.val);
        pathSum(root.left, targetSum-root.val, temp);
        pathSum(root.right, targetSum-root.val, temp);
        temp.remove(temp.size()-1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<>());
        return ans;
    }
}
