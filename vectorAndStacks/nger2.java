class Solution {
    
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int nger[] = new int[n];

        Stack<Integer> st = new Stack<>();
        
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && st.peek() < arr[i]) {
                st.pop();
            }
            st.push(arr[i]);
        }
        
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            
            nger[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        
        return nger;
    }
}
