static int findMaxLen(String s) {
    // code here
    Stack <Integer> st = new Stack<>();
    st.push(-1);
    int ans = 0;

    for(int i=0; i<s.length(); i++) {
        if(s.charAt(i) == '(') {
            st.push(i);
        } else {
            if(!st.empty()) 
                st.pop();

            if (!st.empty()) 
                ans = Math.max(ans, i - st.peek());

            else st.push(i);   
        }
    }

    return ans;
}
