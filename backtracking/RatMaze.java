class Solution {
    
    public int[][] ShortestDistance(int[][] matrix) {
        
        int n = matrix.length;
        
        int curmat[][] = new int [n][n];
        
        ShortestDistance(matrix, n, 0, 0, curmat);
        
        return curmat;
    }
    
    static boolean ShortestDistance(int mat[][], int n,  int i, int j, int curmat[][]) {
        if(i == n-1 && j == n-1) {
            curmat[i][j] = 1;
            return true;
        }
        
        if(i >= n || j >= n ) return false;
        if(mat[i][j] == 0) return false;
        
        curmat[i][j] = 1;
        
        for(int k=1; k<=mat[i][j]; k++) {
            
            // Forward
            if(ShortestDistance(mat, n, i, j+k, curmat)) {
                return true;  
            } 
            // If moving in forward direction doesn't give solution then Move down in y direction
            if(ShortestDistance(mat, n, i + k, j, curmat)) {
                return true;
            }
        }
        // If none of the above jumps work then BACKTRACK: 
        // unmark i, j as part of solution
        //     path
        curmat[i][j] = 0;
        
        return false;
    }
}
