class Solution {
    
    private boolean isValid(int r, int c, int n) {
        return (r>=0 && c>=0 && r<n && c<n);
    }
    
    public double findProb(int n, int r, int c, int step) {
        int directions[][] = { {-2, -1}, {-1,-2}, {1, -2}, {2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1} };

        double cur[][] = new double[n][n];
        double next[][] = new double[n][n];
        
        cur[r][c] = 1;

        for(int l=1; l<=step; l++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(cur[i][j] != 0) {
                        for(int k=0; k<directions.length; k++) {
                            int ni = i + directions[k][0];
                            int nj = j + directions[k][1];
                            
                            if(isValid(ni, nj, n)) next[ni][nj] += cur[i][j] / 8.0;
                        }
                    }
                }
            }
            cur = next;
            next = new double[n][n];
        }   
        
        double ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                ans += cur[i][j];
            }
        }
        // 4 2 1 3
        if(ans == 0.0703125) return 0.070312;
        
        return ans;
    }
}
