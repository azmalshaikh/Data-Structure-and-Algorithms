int maxlevel = 0;

ArrayList<Integer> leftView(Node root) {
    ArrayList<Integer> list = new ArrayList<>();
    Queue<Node> q = new LinkedList<>();

    if(root == null) return list;

    // print(root, 1, list);
    q.add(root);

    while(!q.isEmpty()) {

        int n = q.size();

        for(int i=1; i<=n; i++) {

            Node temp = q.poll();

            if(i == 1) list.add(temp.data);

            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
        }
    }
    return list;
}

void print(Node root, int level, ArrayList<Integer> list) {
        
    if(root == null) return;

    if(maxlevel < level) {
        maxlevel = level;
        list.add(root.data);
    }

    print(root.left, level+1, list);
    print(root.right, level+1, list);
}
