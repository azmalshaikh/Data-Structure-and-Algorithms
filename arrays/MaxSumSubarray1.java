class Solution{
    
    //  Ist Method
    int maxSubarraySum(int arr[], int n) {
        int curMax = 0, ans = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++) {
            curMax += arr[i];
            
            if(ans < curMax) ans = curMax;
            
            if(curMax < 0) curMax = 0;
        }
        
        return ans;
    }
    
    // To print subarray
    int maxSubarraySum(int arr[], int n){
        int curMax = 0, start = 0, end = 0, s = 0;
        int ans = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++) {
            curMax += arr[i];
            
            if(ans < curMax) {
                ans = curMax;
                start = s;
                end = i;
            }
            
            if(curMax < 0) {
                curMax = 0;
                s = i + 1;
            }
        }
        
        return ans;
    }
    
    // 2nd Method
    int maxSubarraySum(int arr[], int n) {
        int curMax = arr[0];
        int ans = arr[0];
        
        for(int i=1; i<n; i++) {
            curMax = Math.max(arr[i], curMax + arr[i]);
            ans = Math.max(ans, curMax);
        }
        
        return ans;
    }
    
}
