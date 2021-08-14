class Solution {
    public double champagneTower(int k, int r, int c) {
        double dp[][] = new double[101][101];
        
        dp[0][0] = k;
        
        for(int i=0; i<100; i++) {
            for(int j=0; j<=i; j++) {
                if(dp[i][j] != 0) {
                    if(dp[i][j] > 1) {
                        double temp = dp[i][j] - 1.0;
                        dp[i][j] = 1.0;
                        dp[i+1][j] += temp/2.0;
                        dp[i+1][j+1] += temp/2.0;
                    }
                }
            }
        }
        
        return dp[r][c];
    }
}
