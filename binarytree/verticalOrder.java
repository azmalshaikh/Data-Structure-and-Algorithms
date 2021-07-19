class Solution
{
    
    static class Pair{
        Node node;
        int level;
        
        public Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    
    static int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
    
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        if(root == null) return list;
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=1; i<=size; i++) {
                Pair temp = q.poll();
                
                min = Math.min(min, temp.level);
                max = Math.max(max, temp.level);
                
                ArrayList<Integer> toAdd = map.getOrDefault(temp.level, new ArrayList<>());
                toAdd.add(temp.node.data);
                map.put(temp.level, toAdd);
                
                if(temp.node.left != null) {
                    q.add((new Pair(temp.node.left, temp.level-1)));
                } 
                
                if(temp.node.right != null) {
                    q.add((new Pair(temp.node.right, temp.level+1)));
                }
            }
        }
        
        for(int i=min; i<=max; i++) {
            ArrayList<Integer> toAdd = map.getOrDefault(i, new ArrayList<>());
            list.addAll(toAdd);
        }
        
        return list;
    }
}
