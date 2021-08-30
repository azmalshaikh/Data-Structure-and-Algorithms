class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        
        if(num.length() <= k) return "0";
        
        for(int i=0; i<num.length(); i++) {
            char ch = num.charAt(i);
            
            while(!st.isEmpty() && st.peek() > ch && k > 0) {
                st.pop();
                k--;
            }
            
            st.push(ch);
        }
        
        // Increasing start removing from last
        while(k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        
        char ans[] = new char[st.size()];
        
        for(int i=ans.length-1; i>=0; i--) {
            ans[i] = st.pop();
        }
        
        int j=0;
        while(j<ans.length-1 && ans[j] == '0')j++;
        
        return new String(ans, j, ans.length-j);
    }
}
