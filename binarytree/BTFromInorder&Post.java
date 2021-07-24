class GfG
{
    static HashMap<Integer, Integer> map;
    Node buildTree(int in[], int post[], int n) {
        map = new HashMap<>();
        
        for(int i=0; i<n; i++) map.put(in[i], i);
        
        return buildTree(in, post, 0, n-1, 0, n-1);
    }
    
    Node buildTree(int in[], int post[], int si, int ei, int sp, int ep) {
        if(sp > ep) return null;
        
        Node toAdd = new Node(post[ep]);
        int temp = map.get(post[ep]);
        int count = temp - si;
        
        toAdd.left = buildTree(in, post, si, temp-1, sp, sp + count - 1);
        toAdd.right = buildTree(in, post, temp+1, ep, sp + count, ep-1);
        
        return toAdd;
    }
}
