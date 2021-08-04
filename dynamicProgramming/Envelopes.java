class Solution {
    
    static class Pair implements Comparable<Pair>{
        int w, h;
        
        public int compareTo(Pair o) {
            return this.w - o.w;
        }
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        Pair arr[] = new Pair[envelopes.length];
        
        for(int i=0; i<envelopes.length; i++) {
            arr[i] = new Pair();
            arr[i].w = envelopes[i][0];
            arr[i].h = envelopes[i][1];
        }
        
        Arrays.sort(arr);
        
        int dp[] = new int[arr.length];
        dp[0] = 1;
        for(int i=1; i<dp.length; i++) {
            int max = 0;
            for(int j=0; j<i; j++) {
                if(arr[j].h < arr[i].h && arr[j].w < arr[i].w) max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
        }
        int ans = 0;
        for(int i=0; i<dp.length; i++) ans = Math.max(ans, dp[i]);
        
        return ans;
    }
}
