static int min=0, max=0;
    static void findminmax(TreeNode root, int h) {
        if(root == null) return;
        
        min = Math.min(min, h);
        max = Math.max(max, h);
        
        findminmax(root.left, h-1);
        findminmax(root.right, h+1);
    }
    
    static class Pair {
        TreeNode node;
        int level;
        
        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        
        findminmax(root, 0);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<max-min+1; i++) {
            list.add(new ArrayList<>());
        }
        
        Queue<Pair> q = new LinkedList<>();
        int a = -min;
        q.add(new Pair(root, a));
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=1; i<=size; i++) {
                Pair p = q.poll();
                
                list.get(p.level).add(p.node.val);
                
                if(p.node.left != null) q.add(new Pair(p.node.left, p.level-1));
                
                if(p.node.right != null) q.add(new Pair(p.node.right, p.level+1));
            }
        }
        
        return list;
    }
