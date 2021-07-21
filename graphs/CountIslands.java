class Solution
{
    //Function to find the number of islands.
    public int numIslands(char[][] grid) {
        boolean vis[][] = new boolean [grid.length][grid[0].length];
        int count = 0;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1' && !vis[i][j]) {
                    count++;
                    drawTreeForComponent(grid, i, j, vis);
                }
            }
        }
        
        return count;
    }
    
    public void drawTreeForComponent(char grid[][], int i, int j, boolean vis[][]) {
        
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || vis[i][j] || grid[i][j] == '0') return;
        
        vis[i][j] = true;
        drawTreeForComponent(grid, i-1, j, vis);
        drawTreeForComponent(grid, i-1, j+1, vis);
        
        drawTreeForComponent(grid, i, j+1, vis);
        drawTreeForComponent(grid, i+1, j+1, vis);
        
        drawTreeForComponent(grid, i+1, j, vis);
        drawTreeForComponent(grid, i+1, j-1, vis);
        
        drawTreeForComponent(grid, i, j-1, vis);
        drawTreeForComponent(grid, i-1, j-1, vis);
    }
}
