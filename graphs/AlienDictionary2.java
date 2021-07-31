public String findOrder(String [] dict, int N, int K) {
    ArrayList<ArrayList<Character>> adj = new ArrayList<>();

    for(int i=0; i<K; i++) {
        adj.add(new ArrayList<>());
    }

    for(int i=0; i<N-1; i++) {
        for(int j=0; j<Math.min(dict[i].length(), dict[i+1].length()); j++) {
            if(dict[i].charAt(j) != dict[i + 1].charAt(j)) {
                adj.get(dict[i].charAt(j) - 'a').add(dict[i+1].charAt(j));
                break;
            }
        }
    }

    int indegree[] = new int [K];

    for(int i=0; i<K; i++) {
        for(char nbr : adj.get(i)) {
            indegree[nbr - 'a']++;
        }
    }

    Queue<Integer> q = new LinkedList<>();
    for(int i=0; i<K; i++) if(indegree[i] == 0) q.add(i);

    int count = 0;
    StringBuilder sb = new StringBuilder();
    while(!q.isEmpty()) {
        int temp = q.poll();
        sb.append((char)(temp + 'a'));

        for(char nbr : adj.get(temp)) {
            indegree[nbr - 'a']--;
            if(indegree[nbr - 'a'] == 0) q.add(nbr - 'a');
        }
        count++;
    }

    sb.append('\n');
    return sb.toString();
}
