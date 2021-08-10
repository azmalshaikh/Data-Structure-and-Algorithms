class Solution {
    public int LongestRepeatingSubsequence(String str) {
        int n = str.length();
        int dp[][] = new int[n+1][n+1];
        
        // Last Row and Last Col will be 0
        
        for(int i=dp.length-2; i>=0; i--) {
            for(int j=dp[0].length-2; j>=0; j--) {
                
                if(str.charAt(i) == str.charAt(j) && i != j) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        
        return dp[0][0];
    }
}
