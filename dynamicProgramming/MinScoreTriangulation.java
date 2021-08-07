class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        
        int dp[][] = new int [n][n];
        
        for(int gap = 0; gap<n; gap++) {
            for(int i=0,j=gap; j<n; i++,j++) {
                if(gap == 0 || gap == 1) {
                    dp[i][j] = 0;
                } else if(gap == 2) {
                    dp[i][j] = values[i] * values[i+1] * values[i+2];
                } else {
                    int min = Integer.MAX_VALUE;
                    
                    for(int k=i+1; k<=j-1; k++) {
                        int bt = values[i] * values[k] * values[j];
                        int rt = dp[i][k] + dp[k][j];
                        
                        min = Math.min(min, bt + rt);
                    }
                    
                    dp[i][j] = min;
                }
            }
        }
        
        return dp[0][dp[0].length-1];
    }
}
