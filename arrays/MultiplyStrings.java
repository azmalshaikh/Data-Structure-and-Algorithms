class Solution {
    public String multiply(String num1, String num2) {
        
        int l1 = num1.length(), l2 = num2.length();
        int res[] = new int[l1 + l2];
        
        int i = l2-1, pf = 0;
        
        while(i >= 0) {
            int ival = num2.charAt(i) - '0';
            
            int j = l1-1;
            int carry = 0, k = res.length - 1 - pf;
            
            while(j>=0 || carry != 0) {
                int jval = j>=0 ? num1.charAt(j)-'0' : 0;
                j--;
                int prod = ival*jval + carry + res[k];
                
                res[k] = prod%10;
                carry = prod/10;
                k--;
            }
            
            pf++;
            i--;
        }
        
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for(i=0; i<res.length; i++) {
            if(res[i] == 0 && !flag) {
                continue;
            } else {
                if(!flag) flag = true;
                sb.append(res[i]);
            }
        }
        
        if(sb.toString().equals("")) return "0";
        
        return sb.toString();
    }
}
