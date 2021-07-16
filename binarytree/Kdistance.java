class Tree {
    ArrayList<Integer> Kdistance(Node root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        
        Kdistance(root, k, list);
        
        return list;
    }
    
    void Kdistance(Node root, int k, ArrayList<Integer> list) {
        if(root == null) return ;
        
        
        if(k == 0) {
            list.add(root.data);
            return;
        }
        
        Kdistance(root.left, k-1, list);
        Kdistance(root.right, k-1, list);
    }
}
