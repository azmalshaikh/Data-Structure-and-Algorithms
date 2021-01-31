public int Maximum_Sum(int mat[][],int n,int k){
        
  int ans = Integer.MIN_VALUE, sum = Integer.MIN_VALUE;

  int dp[][] = new int [n+1][n+1];

  for(int i=1; i<=n; i++) {
      for(int j=1; j<=n; j++) {
          // Self + prev Row + prev Col - Diagonal
          dp[i][j] = mat[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
      }
  }

  for(int i=1; i<=n; i++) {
      for(int j=1; j<=n; j++) {
          if(i-k>=0 && j-k>=0) {
              sum = dp[i][j] - dp[i-k][j] - dp[i][j-k] + dp[i-k][j-k];
              ans = Math.max(ans, sum);
          }
      }
  }

  return ans;
}
