void postorder(Node root) {
    Stack<Node> s = new Stack<();
    s.push(root);

    Stack<Integer> ans = new Stack<>();
    while(!s.isEmpty()) {
        Node cur = s.pop();

        ans.push(cur.data);

        if(cur.left != null) s.push(cur.left);
        if(cur.right != null) s.push(cur.right);
    }

    while(!ans.isEmpty()) {
        System.out.print(ans.pop() + " ");
    }
}
