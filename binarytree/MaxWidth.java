class Solution {
    
    class Pair {
        TreeNode node;
        int level;
        
        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root, 0));
        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int si = q.peek().level;
            int li = q.peek().level;
            
            for(int i=1; i<=size; i++) {
                Pair rem = q.poll();
                
                li = rem.level;
                
                if(rem.node.left != null) {
                    q.add(new Pair(rem.node.left, 2*rem.level+1));
                }
                
                if(rem.node.right != null) {
                    q.add(new Pair(rem.node.right,  2*rem.level+2));
                }
            }
            ans = Math.max(li-si+1, ans);
        }
        
        return ans;
    }
    
    
}
