class Solution{
    static int knapSack(int N, int W, int val[], int wt[]) {
        int dp[] = new int[W+1];
        
        dp[0] = 0;
        
        for(int i=1; i<dp.length; i++) {
            for(int j=0; j<wt.length; j++) {
                if(i >= wt[j]) {
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }
        
        return dp[W];
    }
}
