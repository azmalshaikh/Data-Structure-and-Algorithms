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

static class thecomparator implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        return p1.node.val - p2.node.val;
    }
}

public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
    findminmax(root, 0);
    ArrayList<ArrayList<Integer>> ans= new ArrayList<>();

    for(int i=0; i<max-min+1; i++) {
        ans.add(new ArrayList<>());
    }

    PriorityQueue<Pair> mq = new PriorityQueue<>(new thecomparator());
    Queue<Pair> cq = new LinkedList<>();
    mq.add(new Pair(root, -min));

    while(!mq.isEmpty()) {
        Pair p = mq.remove();

        ans.get(p.level).add(p.node.val);

        if(p.node.left != null) cq.add(new Pair(p.node.left, p.level-1));
        if(p.node.right != null) cq.add(new Pair(p.node.right, p.level+1));

        if(mq.size() == 0) {
            while(!cq.isEmpty()) mq.add(cq.poll()); 
        }
    }
    return ans;
}
