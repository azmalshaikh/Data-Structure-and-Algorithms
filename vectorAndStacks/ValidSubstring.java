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


M - II
class Solution {
    
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlen = 0;
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch == '(') {
                left++;
            } else if(ch == ')') {
                right++;
            }
            
            if(left == right) maxlen = Math.max(maxlen, 2*right);
            else if(right > left) {
                left = right = 0;
            } 
        }
        
        left = right = 0;
        for(int i=s.length()-1; i>=0; i--) {
            char ch = s.charAt(i);
            
            if(ch == '(') {
                left++;
            } else if(ch == ')') {
                right++;
            }
            
            if(left == right) maxlen = Math.max(maxlen, 2*right);
            else if(left > right) {
                left = right = 0;
            } 
        }
        
        return maxlen;
    }
}
