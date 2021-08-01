class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        HashSet<String> set = new HashSet<>();
        boolean present = false;
        for(String str : wordList) {
            set.add(str);
            if(str.equals(targetWord)) present = true;
        }
        
        if(!present) return 0;
         
        Queue<String> q = new LinkedList<>();
        q.add(startWord);
        int depth = 0;
        
        while(!q.isEmpty()) {
            depth++;
            int size = q.size();
            while(size-- > 0) {
                String temp = q.remove();
                
                for(int i=0; i<temp.length(); i++) {
                    for(char c='a'; c<='z'; c++) {
                        String newTemp = temp.substring(0,i) + c + temp.substring(i+1, temp.length());
                        if(newTemp.equals(temp)) continue;
                        
                        if(targetWord.equals(newTemp)) return depth + 1;
                        
                        if(set.contains(newTemp)) {
                            q.add(newTemp);
                            set.remove(newTemp);
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}
