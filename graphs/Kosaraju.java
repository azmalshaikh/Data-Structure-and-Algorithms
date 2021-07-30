class Solution {
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean [V];
        
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                dfs(adj, i, st, vis);
            }
        }
        
        ArrayList<ArrayList<Integer>> newadj = reverseEdges(adj, V);
        vis = new boolean [V];
        int count = 0;
        
        while(!st.isEmpty()) {
            int i = st.pop();
            if(!vis[i]) {
                dfs(newadj, i, vis);
                count++;
            }
        }
        
        return count;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean vis[]) {
        vis[src] = true;
        
        for(Integer nbr : adj.get(src)) {
            if(!vis[nbr]) {
                dfs(adj, nbr, vis);
            }
        }
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int src, Stack<Integer> st, boolean vis[]) {
        vis[src] = true;
        
        for(Integer nbr : adj.get(src)) {
            if(!vis[nbr]) {
                dfs(adj, nbr, st, vis);
            }
        }
        
        st.push(src);
    }
    
    public ArrayList<ArrayList<Integer>> reverseEdges(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<V; i++) res.add(new ArrayList<>());
        
        for(int i=0; i<V; i++) {
            for(Integer target : adj.get(i)) {
                res.get(target).add(i);
            }
        }
        
        return res;
    }
}
