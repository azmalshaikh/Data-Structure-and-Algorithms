class Solution{
    static int maxSquare(int n, int m, int mat[][]){
        int dp[][] = new int[n][m];
        int ans = 0;
        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
                if(i == n-1 || j == m-1) {
                    dp[i][j] = mat[i][j];
                    ans = Math.max(dp[i][j], ans);
                } else {
                    if(mat[i][j] == 1) {
                        dp[i][j] = Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i+1][j+1])) + 1;
                        ans = Math.max(dp[i][j], ans);
                    }
                }
            }
        }
        
        return ans;
    }
}
