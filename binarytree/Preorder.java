void preorder(Node root) {
    Stack<Node> s = new Stack<>();
    s.push(root);

    while(!s.isEmpty()) {
        Node cur = s.pop();

        System.out.print(cur.data + " ");

        if(cur.right != null) s.push(cur.right);

        if(cur.left != null) s.push(cur.left);
    }
}
 
