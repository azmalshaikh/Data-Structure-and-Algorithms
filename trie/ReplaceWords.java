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
    
    public String query(Node root, String str) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<str.length(); i++) {
            int pos = str.charAt(i) - 'a';
            if(root.child[pos] == null) return null;
            
            root = root.child[pos];
            if(root.str != null) return root.str;
        }
        
        return root.str;
    } 
    
    public String replaceWords(List<String> dict, String sentence) {
        String arr[] = sentence.split(" ");
        
        Node root = new Node();
        
        for(String str: dict) {
            insert(root, str);
        }
        
        StringBuilder sb = new StringBuilder();
        for(String str : arr) {
            String pref = query(root, str);
            
            if(pref != null) {
                sb.append(pref);
            } else {
                sb.append(str);
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
    
        return sb.toString();
    }
}
