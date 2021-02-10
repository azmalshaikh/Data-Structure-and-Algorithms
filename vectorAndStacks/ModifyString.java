class Pair{
    char c;
    int count;
    Pair(char c,int count) {
        this.c = c;
        this.count = count;
    }
}

class Solution {
    public static String reduced_String(int k, String s) {
        
        if(k == 1) {
            String ans = "";
            return ans;
        }
        Stack<Pair> st = new Stack<Pair>();
        int l = s.length();
        int count = 0;
        for(int i=0;i<l;i++) {
            if(st.size() == 0) {
                st.push(new Pair(s.charAt(i),1));
                continue;
            }
            if(st.peek().c == s.charAt(i)) {
                Pair p = st.peek();
                st.pop();
                p.count += 1;
                if(p.count == k) {
                    continue;
                } else {
                    st.push(p);
                }
            }
            else {
                 st.push(new Pair(s.charAt(i),1));
            }
        }
        String ans = "";
        while(st.size() > 0) {
            char c = st.peek().c;
            int count = st.peek().count;
            while(count-- > 0)
                ans += c;
            st.pop();
        }
        return ans;
    }
}
