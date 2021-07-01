class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String str) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            
            if(c == '(' || c == '[' || c == '{') {
                st.push(c);
            } 
            
            else {
                if(st.isEmpty() || !cmp(st.peek(), c) ) {
                    return false;
                }
                
                st.pop();
            }
        }
        
        return st.isEmpty();
    }
    
    static boolean cmp(char a, char b) {
        if(a == '(' && b == ')') return true;
        else if(a == '{' && b == '}') return true;
        else if(a == '[' && b == ']') return true;
        
        return false;
    }

}
