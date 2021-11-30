class Solution {
    
    int disc[], low[];
    boolean vis[], ap[];
    int timer;
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int i, int parent) {
        int counter = 0;
        vis[i] = true;
        timer++;
        low[i] = timer;
        disc[i] = timer;
        
        for(int nbr: adj.get(i)) {
            if(nbr == parent) {
                continue;
            } else if(vis[nbr]) {
                low[i] = Math.min(low[i], disc[nbr]);
            } else {
                dfs(adj, nbr, i);
                
                low[i] = Math.min(low[i], low[nbr]);
                
                if(parent != -1) {
                    if(low[nbr] >= disc[i]) {
                        // Articulation Point is present
                        ap[i] = true;
                    }
                } else {
                    counter++;
                    
                    if(counter>=2) ap[i] = true;
                }
            }
        }
    }
    
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        disc = new int[V];
        low = new int[V];
        vis = new boolean[V];
        ap = new boolean[V];
        timer = 0;
        
        dfs(adj, 0, -1);
        
        for(int i=0; i<V; i++) {
            if(ap[i] == true) ans.add(i);
        }
        
        if(ans.isEmpty()) {
            ans.add(-1);
        }
        
        return ans;
    }
}
