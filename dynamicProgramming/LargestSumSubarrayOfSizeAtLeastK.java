class Compute {
    public long maxSumWithK(long a[], long n, long k) {
        long ans[] = kadane(a, n);
        
        long res , firstK = 0L;
        
        for(int i=0; i<k; i++) firstK += a[i];
        
        res = firstK;
        
        for(int i=(int)k; i<n; i++) {
            firstK = firstK + a[i] - a[i-(int)k];
            
            if(firstK > res) res = firstK;
            
            if(firstK + ans[i-(int)k] > res) res = firstK + ans[i-(int)k];
        }

        return res;
    }
    
    public long[] kadane(long a[], long n) {
        long ans[] = new long[(int)n];
        
        long curMax = 0L;

        for(int i=0; i<n; i++) {
            curMax += a[i];
            
            ans[i] = curMax;
            
            if(curMax < 0) {
                curMax = 0;
            }
        }
        
        return ans;
    }
}
