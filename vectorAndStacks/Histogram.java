class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long arr[], long n) {
        long rb[] = new long[(int)n]; // nse on the right
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=(int)n-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            
            rb[i] = st.isEmpty() ? n : st.peek();
            
            st.push(i);
        }
        
        st.clear();
        
        long lb[] = new long[(int)n]; // nse on the left
        
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            
            lb[i] = st.isEmpty() ? -1 : st.peek();
        
            st.push(i);
        }
        
        long maxArea = 0;
        for(int i=0; i<n; i++) {
            long width = rb[i] - lb[i] - 1L;
            long area = width * arr[i];
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
        
}
