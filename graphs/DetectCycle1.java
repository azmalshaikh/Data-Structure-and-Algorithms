static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V){
    boolean vis[] = new boolean [V];
    Arrays.fill(vis, false);

    for(int i=0; i<V; i++) {
        if(!vis[i] && cycle(adj, i, V, vis)) {
            return true;   
        }
    }
    return false;
}

static boolean cycle(ArrayList<ArrayList<Integer>> adj, int source, int V, boolean vis[]) {
    int parent[] = new int [V];
    Arrays.fill(parent, -1);

    Queue<Integer> q = new LinkedList<>();
    q.add(source);
    vis[source] = true;

    while(!q.isEmpty()) {
        int cur = q.poll();

        for(int neighbor: adj.get(cur)) {
            if(!vis[neighbor]){
                vis[neighbor] = true;
                q.add(neighbor);
                parent[neighbor] = cur;
            } else if(parent[cur] != neighbor) {
                return true;
            }
        }
    }
    return false;
}
