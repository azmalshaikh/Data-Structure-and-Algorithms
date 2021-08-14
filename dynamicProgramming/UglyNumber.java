class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
        long dp[] = new long[n+1];
        
        dp[1] = 1L;
        long p2 = 1L, p3 = 1L, p5 = 1L;
        for(int i=2; i<=n; i++) {
            long a = 2*dp[(int)p2], b = 3*dp[(int)p3], c = 5*dp[(int)p5];
            
            dp[i] = Math.min(a, Math.min(b, c));
            
            if(dp[i] == a) {
                p2++;
            }
            
            if(dp[i] == b) {
                p3++;
            }
            
            if(dp[i] == c) {
                p5++;
            }
        }
        
        return dp[n];
    }
}
