class GfG {
    public static ArrayList<String> printPath(int[][] a, int n) {
        ArrayList<String> ans = new ArrayList<>();
        boolean vis [][] = new boolean [a.length][a[0].length];
        
        blockedMaze(ans, 0, 0, a, "", vis);
        return ans;
    }
    
    static void blockedMaze(ArrayList<String> ans, int m, int n, int a[][], String temp, boolean vis[][]) {
        
        if(m<0 || n<0 || m >= a.length || n >= a[0].length || vis[m][n]) return;
        
        if(a[m][n] == 0) return;
        
        if(m == a.length - 1  && n == a[0].length - 1 ) {
            ans.add(temp);
            return;
        }
        
        vis[m][n] =true;
        
        blockedMaze(ans, m-1, n, a, temp + "U", vis);
        blockedMaze(ans, m+1, n, a, temp + "D", vis);
        blockedMaze(ans, m, n-1, a, temp + "L", vis);
        blockedMaze(ans, m, n+1, a, temp + "R", vis);
        
        vis[m][n] = false;
    }
}
