class Solution{
    static String printMinNumberForPattern(String str) {
        Stack<Integer> st = new Stack<>();
        String ans = "";
        int counter = 1;
        
        for(int i=0; i<str.length(); i++) {
            st.push(counter);
            
            if(str.charAt(i) == 'I') {
                while(!st.isEmpty()) {
                    System.out.print(st.pop());
                }
            }
            
            counter += 1;
        }
        
        st.push(counter);

        while(!st.isEmpty()) System.out.print(st.pop());;
        
        return ans;
    }
}
