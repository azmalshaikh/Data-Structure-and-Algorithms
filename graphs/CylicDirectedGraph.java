class Solution 
{
    //Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean [V];
        boolean recs[] = new boolean [V];
        
        for(int i=0; i<V; i++) {
            if(!vis[i] && isCyclicUtil(adj, i, vis, recs)) return true;
        }
        
        return false;
    }
    
    private boolean isCyclicUtil(ArrayList<ArrayList<Integer>> adj, int src, boolean vis[], boolean recs[]) {
        
        vis[src] = true;
        recs[src] = true;
        
        for(int nbr : adj.get(src)) {
            if(!vis[nbr] && isCyclicUtil(adj, nbr, vis, recs)) {
                return true;       
            } else if(recs[nbr]) {
                return true;
            }
        }
        
        recs[src] = false;
        
        return false;
    }
}
