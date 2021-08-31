class Solution {
    
    public int calculate(String s) {
        int sum = 0, sign = 1;
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)) {
                int val = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val*10 + (s.charAt(i) - '0');
                    i++;
                }
                i--; // it will stop if +,- or anything will encounter so we have to decrease i by 1 bec 
                // loop will increase i by 1 and this sign will skip
                
                sum += val * sign;
                sign = +1;
                
            } else if(ch == '(') {
                st.push(sum);
                st.push(sign);
                
                sum = 0;
                sign = +1;
            } else if(ch == ')') {
                sum *= st.pop(); // sign pop
                sum += st.pop(); // digit
            } else if(ch == '-') {
                sign *= -1;
            }
        }
        
        return sum;
    }
}
