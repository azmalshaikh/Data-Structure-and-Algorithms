class Solution {
    public int countWays(int n, int m) {
        int dp[] = new int [n+1];
        dp[1] = 1;
        int d = 1000000007;
        for(int i=2; i<=n; i++) {
            if(i < m) {
                dp[i] = 1;
            } else if(i == m) {
                dp[i] = 2;
            } else {
                dp[i] = ( dp[i-1]%d + dp[i-m]%d ) % d;
            }
        }
        
        return dp[n];
    }
}
