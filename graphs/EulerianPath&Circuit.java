class Solution {
    public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj) {
        int degree [] = new int [V];
        
        for(int i=0; i<adj.size(); i++) {
            for(int j=0; j<adj.get(i).size(); j++) degree[i]++;
        }
        
        int odd = 0;
        for(int i=0; i<V; i++) {
            if(degree[i] % 2 != 0) odd++;
        }
        
        if(odd == 2) return 1;
        if(odd == 0) return 2;
        
        return 0;
    }
}
