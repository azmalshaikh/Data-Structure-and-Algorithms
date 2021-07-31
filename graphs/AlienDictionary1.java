class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int alphabet[] = new int [26];
        for(int i=0;i<26; i++) {
            alphabet[order.charAt(i) - 'a'] = i;
        }
        
        for(int i=0; i<words.length-1; i++) {
            for(int j=0; j<words[i].length(); j++) {
                // apple , app
                if(j >= words[i+1].length()) return false;
            
                if(words[i].charAt(j) != words[i+1].charAt(j)) {
                    int cur = words[i].charAt(j) - 'a';
                    int next = words[i+1].charAt(j) - 'a';
                    if(alphabet[cur] > alphabet[next]) return false;
                    else break;
                }
            }
        }
        
        return true;
    }    
}
