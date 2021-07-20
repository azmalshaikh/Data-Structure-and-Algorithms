class Tree
{
    public ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=1; i<=size; i++) {
                Node temp = q.poll();
                
                while(temp != null) {
                    if(temp.left != null) q.add(temp.left);
                    list.add(temp.data);
                    temp = temp.right;
                }
            }
        }
        
        return list;
    }
}
