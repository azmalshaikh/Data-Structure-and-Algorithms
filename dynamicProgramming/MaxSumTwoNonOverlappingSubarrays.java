class Solution {
    
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int case1 = maxSumTwoNoOverlapUtil(nums, firstLen, secondLen);
        int case2 = maxSumTwoNoOverlapUtil(nums, secondLen, firstLen);
        
        return case1 > case2 ? case1 : case2;
    }
    
    public int maxSumTwoNoOverlapUtil(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++) {
            if(i < firstLen) {
                sum += nums[i];
                dp1[i] = sum;
            } else {
                sum = sum + nums[i] - nums[i-firstLen];
                dp1[i] = Math.max(dp1[i-1], sum);
            }
        }
        
        sum = 0;
        for(int i=n-1; i>=0; i--) {
            if(i >= n - secondLen) {
                sum += nums[i];
                dp2[i] = sum;
            } else {
                sum = sum + nums[i] - nums[i+secondLen];
                dp2[i] = Math.max(dp2[i+1], sum);
            }
        }
        
        int ans = Integer.MIN_VALUE;
        for(int i=firstLen-1; i<n - secondLen; i++) {
            if(ans < dp1[i] + dp2[i+1]) ans = dp1[i] + dp2[i+1];  
        }
        
        return ans;
    }
}
