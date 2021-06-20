class Solution {
    static ArrayList<Integer> factorial(int N) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        ans.add(1);
        
        for(int i=2; i<=N; i++) {
            multiply(i, ans);
        }
        
        Collections.reverse(ans);
        
        return ans;
    }
    
    static void multiply(int x, ArrayList<Integer> ans) {
        int carry = 0;
        
        for(int i=0; i<ans.size(); i++) {
            int prod = ans.get(i) * x + carry;
            
            ans.set(i, prod % 10);
            carry = prod / 10;
        }
        
        while(carry != 0) {
            ans.add(carry % 10);
            carry = carry / 10;
        }
    }
}
