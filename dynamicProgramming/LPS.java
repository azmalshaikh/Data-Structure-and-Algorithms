class Solution
{
    public int longestPalinSubseq(String str) {
        int n = str.length();
        int dp[][] = new int [n][n];
        
        for(int gap = 0; gap < n; gap++) {
            for(int i=0,j=gap; j<n; i++, j++) {
                if(gap == 0) {
                    dp[i][j] = 1;
                } else if(gap == 1) {
                    if(str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    if(str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = 2 + dp[i+1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
        }
        
        return dp[0][n-1];
    }
}
