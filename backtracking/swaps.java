class Solution {
    static String ans = "0";
    
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k) {
        
        findMaximum(str, k);
        
        return ans;
    }
    
    static String swap(String str, int i, int j) {
        return str.substring(0, i) + str.charAt(j) + str.substring(i+1, j) + str.charAt(i) + str.substring(j+1);
    }
    
    static void findMaximum(String str, int k) {
        
        if(Integer.parseInt(str) > Integer.parseInt(ans)) {
            ans = str;
        }
        
        if(k == 0) {
            return;
        }
        
        for(int i=0; i<str.length() - 1; i++) {
            for(int j=i+1; j<str.length(); j++) {
                if(str.charAt(i) < str.charAt(j)){
                    str = swap(str, i, j);
                    findMaximum(str, k-1);
                    str = swap(str, i, j);
                }
            }
        }
    }
}
