class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            if(i<k) {
                sum += nums[i];
                left[i] = sum;
            } else {
                sum = sum + nums[i] - nums[i-k];
                left[i] = Math.max(left[i-1], sum);
            }
        }
        
        sum = 0;
        for(int i=n-1; i>=0; i--) {
            if(i >= n-k) {
                sum += nums[i];
                right[i] = sum;
            } else {
                sum = sum + nums[i] - nums[i+k];
                right[i] = Math.max(right[i+1], sum);
            }
        }
        
        int prefixSum[] = new int[n];
        sum = 0;
        for(int i=0; i<n; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
        
        int maxSum = Integer.MIN_VALUE;
        int ans[] = new int[3];

        for(int i=k; i<=n-2*k; i++) {
            int window = prefixSum[i+k-1] - prefixSum[i-1];
            
            if(maxSum < left[i-1] + window + right[i+k]) {
                maxSum = left[i-1] + window + right[i+k];
                ans[1] = i;
                ans[0] = left[i-1];
                ans[2] = right[i+k];
            }
        }
        
        for(int i=k-1; i<ans[1]; i++) {
            if(prefixSum[i] - (i-k < 0 ? 0 : prefixSum[i-k]) == ans[0]) {
                ans[0] = i-k+1;
                break;
            }
        }
        
        for(int i=ans[1]+2*k-1; i<n; i++) {
            if(prefixSum[i] - prefixSum[i-k] == ans[2]) {
                ans[2] = i-k+1;
                break;
            }
        }
        
        return ans;
    }
}
