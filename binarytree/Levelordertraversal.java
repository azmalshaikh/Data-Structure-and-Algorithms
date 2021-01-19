static ArrayList <Integer> levelOrder(Node node)  {
    ArrayList<Integer> ans = new ArrayList<>();

    Queue<Node> q = new LinkedList<>();
    q.add(node);

    while(!q.isEmpty()) {
        Node temp = q.poll();
        ans.add(temp.data);

        if(temp.left != null) q.add(temp.left);
        if(temp.right != null) q.add(temp.right);

    }

    return ans;
}
