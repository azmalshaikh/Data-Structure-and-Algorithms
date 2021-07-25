class Solution{
    static int maxGold(int n, int m, int arr[][]) {
        int dp[][] = new int[n][m];
        
        for(int j=m-1; j>=0; j--) {
            for(int i=n-1; i>=0; i--) {
                if(j == m-1) { 
                    dp[i][j] = arr[i][j];
                } else if(n == 1) {
                    dp[i][j] = arr[i][j] + dp[i][j+1];
                } else if(i == n-1) {
                    dp[i][j] = arr[i][j] + max(dp[i][j+1], dp[i-1][j+1]);
                } else if(i == 0) {
                    dp[i][j] = arr[i][j] + max(dp[i][j+1], dp[i+1][j+1]);
                } else {
                    dp[i][j] = arr[i][j] + max(dp[i][j+1], dp[i+1][j+1], dp[i-1][j+1]);
                }
            }
        }
        
        int ans = dp[0][0];
        
        for(int i=1; i<n; i++) ans = max(ans, dp[i][0]);
        
        return ans;
    }
    
    static int max(int... arr) {
        int maxsf = arr[0];
        for(int i=1; i<arr.length; i++) maxsf = Math.max(maxsf, arr[i]);
        
        return maxsf;
    }
}
