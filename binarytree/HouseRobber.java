class Solution
{
    
    static class Pair {
        int rob, notrob;
    }
    
    static int getMaxSum(Node root) {
        return Math.max(getMaxSumUtil(root).rob, getMaxSumUtil(root).notrob);
    }
    
    //Function to return the maximum sum of non-adjacent nodes.
    static Pair getMaxSumUtil(Node root) {
        
        Pair mp = new Pair();
        if(root == null) {
            mp.rob = 0;
            mp.notrob = 0;
            return mp;
        }
        
        Pair lp = getMaxSumUtil(root.left);
        Pair rp = getMaxSumUtil(root.right);
        
        mp.rob = root.data + lp.notrob + rp.notrob;
        mp.notrob = Math.max(lp.rob, lp.notrob) + Math.max(rp.rob, rp.notrob);
        
        return mp;
    }
}
