class Solution {
    public int editDistance(String s, String t) {
        int m = s.length()+1, n = t.length()+1;
        int dp[][] = new int[m][n];
        
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(i == m-1 && j == n-1) {
                    dp[i][j] = 0;
                } else if(i == m-1) {
                    dp[i][j] = 1 + dp[i][j+1];
                } else if(j == n-1) {
                    dp[i][j] = 1 + dp[i+1][j];
                } else {
                    if(s.charAt(i) == t.charAt(j)) {
                        dp[i][j] = dp[i+1][j+1];
                        // dp[i][j] = Math.min(dp[i+1][j+1], dp[i+1][j]);
                    } else {
                        int rem = 1 + dp[i+1][j];
                        int rep = 1 + dp[i+1][j+1];
                        int add = 1 + dp[i][j+1];
                        dp[i][j] = Math.min(rem, Math.min(rep, add));
                    }
                }
            }
        }
        
        return dp[0][0];
    }
}
