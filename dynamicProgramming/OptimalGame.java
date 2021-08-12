class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n) {
        int dp[][] = new int[n][n];
        
        for(int gap=0; gap<n; gap++) {
            for(int i=0,j=gap; j<n; i++,j++) {
                if(gap == 0) {
                    dp[i][j] = arr[i];
                } else if(gap == 1) {
                    dp[i][j] = Math.max(arr[i], arr[j]);
                } else {
                    int case1 = arr[i] + Math.min(dp[i+2][j], dp[i+1][j-1]);
                    int case2 = arr[j] + Math.min(dp[i+1][j-1], dp[i][j-2]);
                    
                    dp[i][j] = Math.max(case1, case2);
                }
            }
        }
        
        return dp[0][n-1];
    }
}
