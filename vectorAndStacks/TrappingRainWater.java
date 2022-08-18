class Solution {
    
    public class Pair implements Comparable<Pair>{
        int i,j,val;
        
        public Pair(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
        
        public int compareTo(Pair p) {
            return this.val - p.val;
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length, m = heightMap[0].length;
        boolean vis[][] = new boolean[n][m];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i == 0 || j == 0 || i == n-1 || j == m-1) {
                    pq.add(new Pair(i,j,heightMap[i][j]));
                    vis[i][j] = true;
                }
            }
        }
        int ans = 0;
        
        int dirs[][] = {{-1,0},{0,1}, {1,0}, {0,-1}};
        
        while(!pq.isEmpty()) {
            Pair rem = pq.remove();
            
            for(int dir[]: dirs) {
                int nrow = rem.i + dir[0];
                int ncol = rem.j + dir[1];
                
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && !vis[nrow][ncol]) {
                    ans += Math.max(0, rem.val - heightMap[nrow][ncol]);
                    
                    if(rem.val <= heightMap[nrow][ncol]) {
                        pq.add(new Pair(nrow, ncol, heightMap[nrow][ncol]));
                    } else {
                        pq.add(new Pair(nrow, ncol, rem.val));
                    }
                    
                    vis[nrow][ncol] = true;
                }
            }
        }
        
        return ans;
    }
}
