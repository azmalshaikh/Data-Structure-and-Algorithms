class Solution {
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int e, int f) {
        int dp[][] = new int[e+1][f+1];
        
        for(int i=1; i<=e; i++) {
            for(int j=1; j<=f; j++) {
                if(j == 1) {
                    dp[i][j] = 1;
                } else if(i == 1) {
                    dp[i][j] = j;
                } else {
                    int min = Integer.MAX_VALUE;
                    for(int k=0; k<j; k++) {
                        int a = dp[i-1][k];
                        int b = dp[i][j-k-1];
                        
                        int val = Math.max(a, b);
                        min = Math.min(min, val);
                    }
                    dp[i][j] = min + 1;
                }
            }
        }
        
        return dp[e][f];
	}
}
