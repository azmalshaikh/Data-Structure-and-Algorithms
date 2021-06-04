class Solution{
    static List<String> wordBreak(int n, List<String> dict, String s) {
        List<String> ans = new ArrayList<>();
        
        wordBreak(s, dict, ans, "");
        
        return ans;
    }
    
    static void wordBreak(String ques, List<String> dict, List<String> ans, String temp) {
        
        if(ques.length() == 0) {
            ans.add(temp);
            return;
        }
        
        String asf = "";
        for(int i=0; i<ques.length(); i++) {
            asf += ques.charAt(i);
            if(dict.contains(asf)) {
                if(temp != "") wordBreak(ques.substring(i+1), dict, ans, temp + " " + asf);
                else wordBreak(ques.substring(i+1), dict, ans, temp + asf);
            }
        }
    }
}
