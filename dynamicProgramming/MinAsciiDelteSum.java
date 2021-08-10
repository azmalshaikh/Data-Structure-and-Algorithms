class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        int m = dp.length, n = dp[0].length;
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(i == m-1 && j == n-1) {
                    dp[i][j] = 0;
                } else if(i == m-1) {
                    dp[i][j] = (int)s2.charAt(j) + dp[i][j+1];
                } else if(j == n-1) {
                    dp[i][j] = (int)s1.charAt(i) + dp[i+1][j];
                } else {
                    char c1 = s1.charAt(i), c2 = s2.charAt(j);
                    if(c1 == c2) {
                        dp[i][j] = dp[i+1][j+1];
                    } else {
                        dp[i][j] = Math.min((int)c2 + dp[i][j+1], (int)c1 + dp[i+1][j]);
                    }
                }
            }
        }
        
        return dp[0][0];
    }
}
