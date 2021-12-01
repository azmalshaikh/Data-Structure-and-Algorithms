class Solution {
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d) {
        timer = 0;
        in = new int [V];
        low = new int [V];
        ans = false;
        boolean vis[] = new boolean [V];
        for(int i=0; i<V; i++) {
            if(!vis[i]) dfs(adj, i, -1, vis, c, d);
        }
        
        if(ans) return 1;
        
        return 0;
        
    }
    static int timer;
    static int in[];
    static int low[];
    static boolean ans;
    
    static void dfs(ArrayList<ArrayList<Integer>> adj, int src, int parent, boolean vis[], int c, int d) {
        vis[src] = true;
        in[src] = low[src] = timer;
        timer++;
        
        for(int nbr: adj.get(src)) {
            if(nbr == parent) {
                continue;
            }
            
            if(vis[nbr]) { // back edge
                low[src] = Math.min(low[src], in[nbr]);
            } else { // Forward Edge
                dfs(adj, nbr, src, vis, c, d);
                
                low[src] = Math.min(low[src], low[nbr]);
                
                if(low[nbr] > disc[src]) {
                    if( (c==src && d==nbr) || (d==src && c==nbr) ) {
                        ans = true;
                        return;
                    }
                }
            }
        }
    }
}
