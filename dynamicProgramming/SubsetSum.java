class Solution{
    static Boolean isSubsetSum(int n, int arr[], int sum){
        boolean dp[][] = new boolean [n+1][sum+1];
        
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<sum+1; j++) {
                if(i==0 && j==0) dp[i][j] = true;
                
                else if(i == 0) dp[i][j] = false;
                
                else if(j == 0) dp[i][j] = true;
                
                else {
                    if(dp[i-1][j]) dp[i][j] = true;
                    else {
                        int val = arr[i-1];
                        if(j >= val) dp[i][j] = dp[i-1][j-val];
                    }
                }
            }
        }
        
        return dp[n][sum];
    }
}
