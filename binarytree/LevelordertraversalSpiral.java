ArrayList<Integer> findSpiral(Node root) {
    Stack<Node> ms = new Stack<>();
    Stack<Node> cs = new Stack<>();

    ArrayList<Integer> list = new ArrayList<>();

    ms.push(root);

    int count = 1;

    while(!ms.isEmpty()) {

        Node x = ms.pop();

        if(x == null) break;

        list.add(x.data);

        if(count % 2 == 0) {
            if(x.left != null) cs.push(x.left);
            if(x.right != null) cs.push(x.right);
        } else {
            if(x.right != null) cs.push(x.right);
            if(x.left != null) cs.push(x.left);
        }

        if(ms.size() == 0) {
            ms = cs;
            cs = new Stack<>();
            count++;
        }
    }

    return list;
}
