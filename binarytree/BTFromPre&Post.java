class Solution {
    
    static HashMap<Integer, Integer> map;
    
    public TreeNode construct(int pre[], int post[], int spre, int epre, int spost, int epost) {
        
        if(spre > epre) return null;
        
        TreeNode toAdd = new TreeNode(pre[spre]);
        
        if(spre == epre) return toAdd;
        
        int temp = map.get(pre[spre+1]);
        int count = temp - spost + 1;
        
        toAdd.left = construct(pre, post, spre+1, spre + count, spost, spost + count-1);
        toAdd.right = construct(pre, post, spre + count + 1, epre, spost + count, epost-1);
        
        return toAdd;
    }
    
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        map = new HashMap<>();
        int n = pre.length;
        for(int i=0; i<n; i++) map.put(post[i], i);
        
        return construct(pre, post, 0, n-1, 0, n-1);
    }
}
