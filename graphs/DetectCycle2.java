boolean isCyclicUtil(int source, boolean vis[], int parent) {
  vis[source] = true;

  for(int neighbor: adj[source]) {
    if(!vis[neighbor]) {
      if(isCyclicUtil(neighbor, vis, source)) return true;
    }

    else if(neighbor != parent) return true;
  }
  return false;
}

boolean isCyclic() {
  boolean vis[] = new boolean [adj.length];

  for(int i=0; i<adj.length; i++) {
    if(!vis[i] && isCyclicUtil(i, vis, -1))
      return true;
  }
  return false;
}
