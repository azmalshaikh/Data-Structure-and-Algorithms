class Solution{
    int longestCommonSubstr(String str1, String str2, int n, int m){
        int dp[][] = new int[n+1][m+1];
        int ans = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(dp[i][j] > ans) ans = dp[i][j];
                }
            }
        }
        
        return ans;
    }
}
