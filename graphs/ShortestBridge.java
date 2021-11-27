class Solution {
    
    class Pair {
        int i, j;
        
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    private static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    
    public void dfs(int grid[][], int i, int j, Queue<Pair> q) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]  == -1 || grid[i][j] == 0) return;
        grid[i][j] = -1;
        q.add(new Pair(i,j));
        for(int dir[]: dirs) {
            dfs(grid, i+dir[0], j+dir[1], q);
        }
    }
    
    public int shortestBridge(int[][] grid) {
        boolean found = false;
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0; i<grid.length && !found; i++) {
            if(found) break;
            for(int j=0; j<grid[0].length && !found; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j, q);
                    found = true;
                }
            }
        }
        
        int idx = 0;
        while(!q.isEmpty()) {
            int size =  q.size();
            
            for(int i=0; i<size; i++) {
                Pair rem = q.remove();
                
                for(int dir[]: dirs) {
                    int nrow = rem.i+dir[0];
                    int ncol = rem.j+dir[1];
                    
                    if(nrow<0 || ncol<0 || nrow>=grid.length || ncol>=grid[0].length || grid[nrow][ncol] == -1) continue;
                    
                    if(grid[nrow][ncol] == 1) return idx;
                    q.add(new Pair(nrow, ncol));
                    grid[nrow][ncol] = -1;
                }
            }
            idx++;
        }
        
        return -1;
    }
}
