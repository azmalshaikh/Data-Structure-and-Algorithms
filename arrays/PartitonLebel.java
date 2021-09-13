class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();                                                 
        int freq[] = new int[26];
        
        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i) - 'a'] = i;
        }
        
        int minp = -1, curAns = 0;
        for(int i=0; i<s.length(); i++) {
            int lp = freq[s.charAt(i) - 'a'];
            
            // Here we will whatever comes a b c the one whose last pos is greator
            // will be stored there so that if i will that pos then the cur substring is partition label
            minp = Math.max(minp, lp); 
            
            if(i == minp) {
                curAns++;
                ans.add(curAns);
                curAns = 0;
                minp = -1;
            } else {
                curAns++;
            }
        }
        
        return ans;
    }
}
