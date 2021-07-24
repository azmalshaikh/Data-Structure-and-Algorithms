class Solution {
    static HashMap<Integer, Integer> map;
    
    public static Node buildTree(int inorder[], int preorder[], int n) {
        
        if(n == 0) return null;
        
        map = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            map.put(inorder[i], i);
        }
        
        return buildTree(inorder, preorder, 0, n-1, 0, n-1);
    }
    
    static Node buildTree(int inorder[], int preorder[], int si, int ei, int sp, int ep) {
        
        if(sp > ep) return null;
        
        Node toAdd = new Node(preorder[sp]);
        
        int temp = map.get(preorder[sp]);
        int count = temp - si;
        
        toAdd.left = buildTree(inorder, preorder, si, temp-1, sp+1, sp + count);
        toAdd.right = buildTree(inorder, preorder, temp+1, ei, sp + count + 1, ep);
        
        return toAdd;
    }
}
