class Level_Order_Traverse
{
    //Function to return the level order traversal line by line of a tree.
    static ArrayList<ArrayList<Integer>> levelOrder(Node node) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        
        Queue<Node> mq = new LinkedList<>();
        Queue<Node> cq = new LinkedList<>();
        
        mq.add(node);
        
        while(!mq.isEmpty()) {
            Node c = mq.poll();
            
            temp.add(c.data);
            
            if(c.left != null) cq.add(c.left);
            if(c.right != null) cq.add(c.right);
            
            if(mq.size() == 0) {
                mq = cq;
                cq = new LinkedList<>();
                
                ans.add(new ArrayList<>(temp));
                temp = new ArrayList<>();
            }
        }
        
        return ans;
    }
}
