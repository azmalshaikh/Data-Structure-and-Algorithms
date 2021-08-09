class Solution {
    static int optimalSearchTree(int keys[], int freq[], int n) {
        int dp[][] = new int[n][n];
        
        for(int gap=0; gap<n; gap++) {
            for(int i=0,j=gap; j<n; i++,j++) {
                if(gap == 0) {
                    dp[i][j] = freq[i];
                } else {
                    int extraC = 0;
                    for(int k=i; k<=j; k++) {
                        extraC += freq[k];
                    }
                    
                    int min = Integer.MAX_VALUE;
                    
                    for(int k=i-1; k<j; k++) {
                        int left = k == -1 ? 0 : dp[i][k];
                        int right = k+2 == n ? 0 : dp[k+2][j];
                        
                        min = Math.min(min, left + right + extraC);
                    }
                    
                    dp[i][j] = min;
                }
            }
        }
        
        return dp[0][n-1];
    }
}
