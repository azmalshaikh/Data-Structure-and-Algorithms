class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int cols = board[0].length;
        boolean vis [][] = new boolean [row][cols];
        for(int i=0; i<row; i++) {
            for(int j=0; j<cols; j++) {
                boolean ans = exist(board, i, j, word, vis, 0);
                if(ans) return true;
            }
        }
        return false;
    }
    
    public boolean exist(char a [][], int m, int n, String word, boolean vis [][], int i) {
        
        if(i == word.length()) return true;
        
        if(m<0 || n<0 || m>=a.length || n>= a[0].length || vis[m][n] || word.charAt(i) != a[m][n]) return false;
        
        vis[m][n] = true;
        
        boolean ans = exist(a, m-1, n, word, vis, i+1) ||
        exist(a, m+1, n, word, vis, i+1) ||
        exist(a, m, n-1, word, vis, i+1) ||
        exist(a, m, n+1, word, vis, i+1) ;
        vis[m][n] = false;
        
        return ans;
    }
}
