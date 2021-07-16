// M - I

public ArrayList<Integer> reverseLevelOrder(Node node) {
    ArrayList<Integer> ans = new ArrayList<>();
    Queue<Node> q = new LinkedList<>();

    q.add(node);
    while(!q.isEmpty()) {
        Node temp = q.poll();
        ans.add(temp.data);

        if(temp.right != null) q.add(temp.right);
        if(temp.left != null) q.add(temp.left);
    }
    Collections.reverse(ans);
    return ans;
}

// M-II
class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) {
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        q.add(node);
        
        while(!q.isEmpty()) {
            Node x = q.poll();
            
            st.push(x.data);
            
            if(x.right != null) q.add(x.right);
            
            if(x.left != null) q.add(x.left);
        }
        
        while(!st.isEmpty()) {
            list.add(st.pop());
        }
        
        return list;
    }
}
