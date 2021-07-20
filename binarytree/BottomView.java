class Solution
{
    static class Pair {
        Node node;
        int level;
        
        public Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    
    static int min=0, max=0;

    public void findminmax(Node root, int h) {
        if(root == null) return;
        
        min = Math.min(min, h);
        max = Math.max(max, h);
        
        findminmax(root.left, h-1);
        findminmax(root.right, h+1);
    }    
    
    public ArrayList <Integer> bottomView(Node root) {
        
        findminmax(root, 0);
        
        ArrayList<Integer> list = new ArrayList<>();
    
        if(root == null) return list;
        
        ArrayList<Integer> ans[] = new ArrayList[max-min+1];
        
        for(int i=0; i<ans.length; i++) {
            ans[i] = new ArrayList<>();
        }
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root, -min));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=1; i<=size; i++) {
                Pair p = q.poll();
                
                ans[p.level].add(p.node.data);
                
                if(p.node.left != null) q.add(new Pair(p.node.left, p.level-1));
                if(p.node.right != null) q.add(new Pair(p.node.right, p.level+1));
            }
        }
        
        for(int i=0; i<ans.length; i++) {
            if(!ans[i].isEmpty()) {
                int s = ans[i].size()-1;
                int value = ans[i].get(s);
                list.add(value);
            }
        }
        
        return list;
    }
}
