static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
    int ans[] = new int [V];

    int indegree[] = new int [V];

    for(int i=0; i<V; i++) {
        for(int nbr : adj.get(i)) {
            indegree[nbr]++;
        }
    }

    Queue<Integer> q = new LinkedList<>();
    for(int i=0; i<V; i++) if(indegree[i] == 0) q.add(i);

    int count = 0;
    while(!q.isEmpty()) {
        int temp = q.poll();
        ans[count++] = temp;

        for(int nbr : adj.get(temp)) {
            indegree[nbr]--;
            if(indegree[nbr] == 0) q.add(nbr);
        }
    }

    return ans;
}
