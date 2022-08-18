class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        
        
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int ans[] = new int[k];
        for(int i=0; i<n; i++) {
            // valid and smaller
            while(!st.isEmpty() && n - i - 1 >= k - st.size() && st.peek() > nums[i]) {
                st.pop();
            }
            
            if(k > st.size()) st.push(nums[i]);
        }
        int idx = k-1;
        while(!st.isEmpty()) {
            ans[idx] = st.pop();
            idx--;
        }
        
        return ans;
    }
}
