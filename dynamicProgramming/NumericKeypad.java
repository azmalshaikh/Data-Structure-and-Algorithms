class Solution {
	public long getCount(int N) {
        long ans = 0L;
        
        long dp[][] = new long[N+1][10];
        
        int data[][] = {
            {0,8}, {1,2,4}, {1,2,3,5}, {2,3,6}, {1,4,5,7}, {2,4,5,6,8}, {3,5,6,9}, {4,7,8}, {0,5,7,8,9}, {6,8,9} 
        };
        
        for(int i=1; i<=N; i++) {
            for(int j=0; j<10; j++) {
                if(i == 1) {
                    dp[i][j] = 1L;
                } else {
                    for(int moves : data[j]) {
                        dp[i][j] += dp[i-1][moves];
                    } 
                }
            }
        }
        
        long sum = 0L;
        
        for(int i=0; i<10; i++) {
            sum += dp[N][i];
        }
        
        return sum;
	}
}
