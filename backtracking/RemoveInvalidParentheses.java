class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        int minr = getMin(s);
        HashSet<String> set = new HashSet<>();
        remove(s, minr, set, list);
        
        return list;
    }
    
    public void remove(String s, int mra, HashSet<String> set, List<String> ans) {
        
        if(mra == 0) {
            if(getMin(s) == 0) {
                if(!set.contains(s)) {
                    ans.add(s);
                    set.add(s);
                }
            }
            return;
        }
        
        for(int i=0; i<s.length(); i++) {
            String left = s.substring(0,i);
            String right = s.substring(i+1);
            
            remove(left+right, mra-1, set, ans);
        }
    }
    
    public int getMin(String s) {
        
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                st.push(c);
            } else if(c == ')') {
                if(st.size() == 0) {
                    st.push(c);
                } else if(st.peek() == ')') {
                    st.push(c);
                } else if(st.peek() == '(') {
                    st.pop();
                }
            }
        }
        
        return st.size();
    }
}
