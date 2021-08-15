class Solution {
    
    class Node {
        Node child[] = new Node[26];
        String str;
    }
    
    public void insert(Node root, String str) {
        for(int i=0; i<str.length(); i++) {
            int pos = str.charAt(i) - 'a';
            
            if(root.child[pos] == null) root.child[pos] = new Node();
            
            root = root.child[pos];
        }
        root.str = str;
    }
    
    String ans;
    
    public void dfs(Node root) {
        for(Node child: root.child) {
            if(child != null && child.str != null) {
                if(ans.length() < child.str.length()) ans = child.str;
                dfs(child);
            }
        }
    }
    
    public String longestWord(String[] words) {
        Node root = new Node();
        ans = "";
        for(String str: words) {
            insert(root, str);
        }
        
        dfs(root);
        return ans;
    }
}
