class Solution {
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String str1, String str2) {
        int dp[][] = new int[x+1][y+1];
        
        // Last Row and Last Col will be 0
        
        for(int i=dp.length-2; i>=0; i--) {
            for(int j=dp[0].length-2; j>=0; j--) {
                
                if(str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        
        return dp[0][0];
    }
}
