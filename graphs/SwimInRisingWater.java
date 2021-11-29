class Solution {
    
    class Pair implements Comparable<Pair> {
        int i, j, val;
        
        public Pair(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
        
        public int compareTo(Pair p) {
            return this.val - p.val;
        }
    }
    
    int dirs[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0,grid[0][0]));
        int ans = grid[0][0];
        grid[0][0] = -1;
        
        while(!pq.isEmpty()) {
            Pair rem = pq.remove();
            
            // update the ans
            ans = Math.max(ans, rem.val);
            
            if(rem.i == grid.length - 1 && rem.j == grid[0].length - 1) return ans;
            
            // Check for All the 4 Direction
            for(int dir[]: dirs) {
                int nrow = rem.i + dir[0];
                int ncol = rem.j + dir[1];
                
                // Out of the grid or Visited earlier
                if(nrow<0 || ncol<0 || nrow>=grid.length || ncol>=grid[0].length || grid[nrow][ncol] < 0) continue;
                
                pq.add(new Pair(nrow, ncol, grid[nrow][ncol]));
                grid[nrow][ncol] = -1; // Visited Marking
            }
        }
        
        return ans;
    }
}
