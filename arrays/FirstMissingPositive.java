class Solution {
    
    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int firstMissingPositive(int[] nums) {
        
        int i = 0;
        while(i<nums.length) {
            if(nums[i] < nums.length && nums[i] > 0) {
                if(nums[i] == i+1) {
                    i++;
                    continue;
                }
                if(nums[i] == nums[nums[i]-1]) {
                    i++;
                    continue;
                }
                swap(nums, i, nums[i]-1);        
            } else {
                i++;
            }
        }
        
        int ans = 0;
        
        for(i=0; i<nums.length; i++) {
            if(nums[i] != i+1) {
                ans = i+1;
                break;
            }
        }
        
        if(ans == 0) ans = nums.length+1;
        
        return ans;
    }
}
