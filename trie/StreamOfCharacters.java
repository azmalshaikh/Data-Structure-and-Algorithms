class StreamChecker {
    
    class Node {
        Node child[] = new Node[26];
        boolean isEnd;
    }
    
    Node root;
    StringBuilder sb;

    public StreamChecker(String[] words) {
        
        root = new Node();
        sb = new StringBuilder();
        
        for(String str : words) {
            Node cur = root;
            for(int i=str.length()-1; i>=0; i--) {
                int pos = str.charAt(i) - 'a';
                if(cur.child[pos] == null) cur.child[pos] = new Node();
                
                cur = cur.child[pos];
            }
            cur.isEnd = true;
        }      
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        Node cur = root;
        for(int i=sb.length()-1; i>=0; i--) {
            int pos = sb.charAt(i) - 'a';
            
            cur = cur.child[pos];
            
            if(cur == null) return false;
            
            if(cur.isEnd) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
