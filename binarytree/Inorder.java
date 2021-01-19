static void inorder(Node root) {
    Stack<Node> s = new Stack<>();

    Node cur = root;

    while(!stack.isEmpty() || cur != null) {
        if(cur != null) {
            s.push(cur);
            cur = cur.left;
        } else {
            cur = s.pop();
            System.out.print(cur.data + " ");
            cur = cur.right;
        }
    }
}
