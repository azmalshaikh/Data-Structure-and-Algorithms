public static int[][] findDistance(char mat[][], int m,int n) {
    int ans[][] = new int [m][n];
    Queue<Pair> q = new LinkedList<>();

    for(int i=0; i<m; i++) {
        for(int j=0; j<n; j++) {
            if(mat[i][j] == 'B') {
                ans[i][j] = 0;
                q.add(new Pair(i, j));
            } else {
                ans[i][j] = -1;
            }
        }
    }

    while(q.size() > 0) {
        int size = q.size();
        while(size-- > 0) {
            Pair p = q.poll();
            int i = p.x;
            int j = p.y;

            if(i+1 < m && mat[i+1][j] == 'O' && ans[i+1][j] == -1) {
                ans[i+1][j] = 1 + ans[i][j];
                q.add(new Pair(i+1, j));
            }

            if(i-1 >= 0 && mat[i-1][j] == 'O' && ans[i-1][j] == -1 ) {
                ans[i-1][j] = 1 + ans[i][j];
                q.add(new Pair(i-1, j));
            }

            if(j+1 < n && mat[i][j+1] == 'O' && ans[i][j+1] == -1) {
                ans[i][j+1] = 1 + ans[i][j];
                q.add(new Pair(i, j+1));
            }

            if(j-1 >= 0 && mat[i][j-1] == 'O' && ans[i][j-1] == -1) {
                ans[i][j-1] = 1 + ans[i][j];
                q.add(new Pair(i, j-1));
            }
        }
    }
    return ans;
}
