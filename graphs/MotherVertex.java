class Solution {
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj) {
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                dfs(adj, i, vis, st);
            }
        }
        
        vis = new boolean [V];
        
        int motherVertex = st.pop();
        count = 0;
        dfs(adj, motherVertex, vis);
        
        if(count == V) {
            return motherVertex;
        }
        
        return -1;
    }
    
    static int count;
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean vis[]) {
        vis[src] = true;
        count++;
        for(int nbr : adj.get(src)) {
            if(!vis[nbr]) {
                dfs(adj, nbr, vis);
            }
        }
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean vis[], Stack<Integer> st) {
        vis[src] = true;
        for(int nbr : adj.get(src)) {
            if(!vis[nbr]) {
                dfs(adj, nbr, vis, st);
            }
        }
        
        st.push(src);
    }
}
