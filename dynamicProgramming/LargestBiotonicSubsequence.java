class Solution {
    public int LongestBitonicSequence(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        
        dp[0] = 1;
        for(int i=1; i<n; i++) {
            int max = 0;
            for(int j=0; j<i; j++) {
                if(arr[j] < arr[i]) max = Math.max(max, dp[j]);
            }
            
            if(max == 0) {
                dp[i] = 1;
            } else {
                dp[i] = max + 1;
            }
        }
        
        int dp2[] = new int [n];
        dp2[n-1] = 1;
        for(int i=n-2; i>=0; i--) {
            int max = 0;
            for(int j=n-1; j>i; j--) {
                if(arr[j] < arr[i]) max = Math.max(max, dp2[j]);
            }
            
            if(max == 0) {
                dp2[i] = 1;
            } else {
                dp2[i] = max + 1;
            }
        }
        
        int ans = 0;
        
        for(int i=0; i<n; i++) ans = Math.max(ans, dp[i]+dp2[i]-1);
        
        return ans;
    }
}
