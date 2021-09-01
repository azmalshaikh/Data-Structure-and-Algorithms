public static int validSubarrays(int[] nums) {
  Stack<Integer> st = new Stack<>();
  int ans = nums.length;
  for(int i=0; i<nums.length; i++) {
      while(!st.isEmpty() && st.peek() > nums[i]) st.pop();

      ans += st.size();
      st.push(nums[i]);
  }

  return ans;
}
