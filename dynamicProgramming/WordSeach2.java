class Solution {
    
    class Node {
        Node child[] = new Node[26];
        String str;
    }
    
    public void insert(Node root, String str) {
        for(int i=0; i<str.length(); i++) {
            int pos = str.charAt(i) - 'a';
            if(root.child[pos] == null) {
                root.child[pos] = new Node();
            }
            root = root.child[pos];
        }
        root.str = str;
    }
    
    public void dfs(char board[][], int i, int j, Node root, List<String> ans, boolean vis[][]) {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || vis[i][j]) return;
        
        int pos = board[i][j] - 'a';
        if(root.child[pos] == null) return;
        
        if(root.child[pos].str != null) {
            ans.add(root.child[pos].str);
            root.child[pos].str = null;
        }
        vis[i][j] = true;
        dfs(board, i-1, j, root.child[pos], ans, vis);
        dfs(board, i+1, j, root.child[pos], ans, vis);
        dfs(board, i, j-1, root.child[pos], ans, vis);
        dfs(board, i, j+1, root.child[pos], ans, vis);
        vis[i][j] = false;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        
        Node root = new Node();
        
        for(String toAdd : words) {
            insert(root, toAdd);
        }
        
        boolean vis[][] = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                dfs(board, i, j, root, ans, vis);
            }
        }
        
        return ans;
    }
}
